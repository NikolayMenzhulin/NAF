package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.InjectableDialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.fragment_delegate.ViewModelFragmentDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Базовый dialog fragment с поддержкой работы с view model.
 *
 * @property vmFactory фабрика для создания view model
 * @property vm view model, связанная с dialog fragment
 */
abstract class ViewModelDialogFragment<VM : BaseViewModel> : InjectableDialogFragment() {

    @Inject
    lateinit var vmFactory: ViewModelFactory.Factory

    protected abstract val vm: VM

    private val delegate by lazy { ViewModelFragmentDelegate(this) }

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        delegate.getDefaultViewModelProviderFactory(vmFactory)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        delegate.onSaveInstantState(vm)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        delegate.onDestroyView()
    }

    /**
     * Подписаться на данные из [Flow].
     *
     * @param lifecycleOwner жизненный цикл view для привязки к нему состояния подписки
     * @param observer действия для выполнения при получении данных от [Flow]
     *
     * @return [Job] корутины, запущенной в результате создания подписки
     */
    protected fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit): Job =
        lifecycleOwner.lifecycleScope.launchWhenStarted {
            onEach(observer::invoke).collect()
        }.also(delegate::addCoroutineJob)
}