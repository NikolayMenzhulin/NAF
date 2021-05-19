package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Базовый класс делегата для view model, инкапсулирующий логику навигации.
 *
 * @property route роут экрана для получения пареданных параметров
 * @property router роутер для осуществления навигации между экранами
 */
abstract class AbstractNavDelegate<ROUTER : Router, ROUTE : Route> {

    abstract val route: ROUTE

    protected abstract val router: ROUTER

    /**
     * Закрыть экран.
     */
    fun exit() {
        router.exit()
    }

    /**
     * Отправить результат работы экрана.
     *
     * @param key ключ, идентифицирующий отправляемый результат
     * @param screenResult результат работы экрана
     */
    protected fun <T : Any> Router.sendScreenResult(key: String, screenResult: T) {
        sendResult(key, screenResult)
    }

    /**
     * Получить результат работы экрана.
     *
     * @param key ключ, идентифицирующий получаемый результат
     *
     * @return результат работы экрана
     */
    protected suspend inline fun <reified T : Any> Router.getScreenResult(key: String): T =
        suspendCancellableCoroutine { continuation ->
            setResultListener(key) { screenResult ->
                continuation.resume(screenResult as T)
            }
        }
}