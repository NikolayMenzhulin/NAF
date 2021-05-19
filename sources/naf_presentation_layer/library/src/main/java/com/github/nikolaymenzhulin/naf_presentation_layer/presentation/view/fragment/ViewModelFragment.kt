package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.SavedStateViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Базовый fragment с поддержкой работы с view model.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 *
 * @property vmFactory фабрика для создания view model
 * @property vm view model, связанная с fragment
 */
abstract class ViewModelFragment<VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int
) : InjectableFragment(contentLayoutId) {

    @Inject
    lateinit var vmFactory: ViewModelFactory.Factory

    protected abstract val vm: VM

    private val coroutineJobs: MutableList<Job> = mutableListOf()

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        vmFactory.create(this, arguments)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        (vm as? SavedStateViewModel)?.onSaveInstantState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        coroutineJobs.apply {
            forEach(Job::cancel)
            clear()
        }
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
        }.also(coroutineJobs::add)
}