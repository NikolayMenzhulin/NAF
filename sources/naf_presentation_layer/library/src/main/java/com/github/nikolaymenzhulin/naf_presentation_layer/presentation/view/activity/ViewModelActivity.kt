package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity

import android.os.Bundle
import android.os.PersistableBundle
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

    /**
     * Callback для подписки на данные из view model.
     * Вызывается на этапе выполнения onCreate, после вызова super.onCreate.
     */
    protected abstract fun onObserveViewModelData()

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        vmFactory.create(this, intent.extras)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        vm.onSaveInstantState()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
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