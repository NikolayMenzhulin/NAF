package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.InjectableActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.SavedStateViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Базовая activity с поддержкой работы с view model.
 *
 * @param contentLayoutId layout id вёрстки для activity
 *
 * @property vmFactory фабрика для создания view model
 * @property vm view model, связанная с activity
 */
abstract class ViewModelActivity<VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int
) : InjectableActivity(contentLayoutId) {

    @Inject
    lateinit var vmFactory: ViewModelFactory.Factory

    protected abstract val vm: VM

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        vmFactory.create(this, intent.extras)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        (vm as? SavedStateViewModel)?.onSaveInstantState()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        (vm as? SavedStateViewModel)?.onSaveInstantState()
    }

    /**
     * Подписаться на данные из [Flow].
     *
     * @param lifecycleOwner жизненный цикл view для привязки к нему состояния подписки
     * @param observer действия для выполнения при получении данных от [Flow]
     */
    protected fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
        lifecycleOwner.lifecycleScope.launchWhenStarted {
            onEach(observer::invoke).collect()
        }
    }
}