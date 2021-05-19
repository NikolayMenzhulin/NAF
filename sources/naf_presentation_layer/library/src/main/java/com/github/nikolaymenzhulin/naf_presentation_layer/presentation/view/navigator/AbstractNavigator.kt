package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.lifecycle.*
import androidx.navigation.NavController
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.io.Serializable

/**
 * Базовый класс navigator.
 *
 * @param commonDeps основные зависимости, которые необходимы navigator
 *
 * @property vm view model, связанная с navigator
 * @property navController [NavController], связанный с navigator
 * @property arguments аргументы, полученные от предыдущего экрана в стэке навигации
 * @property lifecycleOwner жизненный цикл view, к которому привязан жизненный цикл navigator
 */
abstract class AbstractNavigator<VM : BaseViewModel>(commonDeps: CommonNavigatorDeps) {

    protected abstract val vm: VM

    protected val navController: NavController = commonDeps.navController

    protected val arguments: Bundle? = commonDeps.arguments

    private val lifecycleOwner: LifecycleOwner = commonDeps.lifecycleOwner

    /**
     * Callback для установки результатов работы экрана.
     * Вызывается при получении события onBackPressed, перед вызовом super.onBackPressed.
     * Сначала будет вызван для всех fragment у activity, а потом у самой activity.
     */
    open fun onSetNavigationResult() {
        // Empty realization.
    }

    /**
     * Закрыть текущий экран.
     */
    open fun finish() {
        onSetNavigationResult()
        navController.popBackStack()
    }

    /**
     * Установить результат работы экрана.
     *
     * @param key ключ, идентифицирующий результат
     * @param result данные, являющиеся результатом работы экрана
     */
    protected fun <T : Serializable> setNavigationResult(key: String, result: T): Unit? =
        navController.previousBackStackEntry?.savedStateHandle?.setIfNotExist(key, result)

    /**
     * Установить результат работы экрана.
     *
     * @param destinationId id экрана, которому будет перед результат
     * @param key ключ, идентифицирующий результат
     * @param result данные, являющиеся результатом работы экрана
     */
    protected fun <T : Serializable> setNavigationResult(@IdRes destinationId: Int, key: String, result: T): Unit =
        navController.getBackStackEntry(destinationId).savedStateHandle.setIfNotExist(key, result)

    /**
     * Получить результат работы экрана.
     *
     * @param key ключ, идентифицирующий результат
     *
     * @return данные, найденные по ключу, либо null, если они отсутствуют
     */
    protected fun <T : Serializable> getNavigationResult(key: String): T? =
        navController.currentBackStackEntry?.savedStateHandle
            ?.run {
                val result: T? = get(key)
                remove<T>(key)
                result
            }

    /**
     * Подписаться на результат работы экрана.
     *
     * @param key ключ, идентифицирующий результат
     *
     * @return [SharedFlow], подписанный на изменения данных, найденных по ключу, либо null, если они отсутствуют
     */
    protected fun <T : Serializable> getNavigationResultFlow(key: String): SharedFlow<T>? {
        val resultFlow: MutableSharedFlow<T> = MutableSharedFlow(replay = 1, onBufferOverflow = DROP_OLDEST)
        val savedStateHandle: SavedStateHandle? = navController.currentBackStackEntry?.savedStateHandle
        val resultLiveData: LiveData<T> = savedStateHandle?.getLiveData(key) ?: return null
        resultLiveData.observe(lifecycleOwner, Observer { result ->
            vm.viewModelScope.launch {
                resultFlow.tryEmit(result)
                savedStateHandle.remove<T>(key)
            }
        })
        return resultFlow
    }

    private fun <T : Serializable> SavedStateHandle.setIfNotExist(key: String, result: T) {
        if (!contains(key) || get<T>(key) != result) {
            set(key, result)
        }
    }
}