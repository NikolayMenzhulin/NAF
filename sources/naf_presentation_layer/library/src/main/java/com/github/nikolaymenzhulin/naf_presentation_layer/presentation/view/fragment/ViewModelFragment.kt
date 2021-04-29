package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
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

    /**
     * Callback для подписки на данные из view model.
     * Вызывается на этапе выполнения onActivityCreated, после вызова super.onActivityCreated.
     */
    protected abstract fun onObserveViewModelData()

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        vmFactory.create(this, arguments)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        vm.onSaveInstantState()
    }

    /**
     * Подписаться на данные из [Flow].
     *
     * @param lifecycleOwner жизненный цикл view для привязки к нему состояния подписки
     * @param observer действия для выполнения при получении данных от [Flow]
     */
    protected fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
        onEach(observer::invoke)
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .launchIn(lifecycleOwner.lifecycleScope)
    }
}