package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import androidx.lifecycle.viewModelScope
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

/**
 * Базовый класс view model содержащий логику для работы с корутинами.
 *
 * @property errorHandler обработчик ошибок
 * @property coroutineJobs map, где ключ - название корутины, запущенной во view model, а значение - [Job] этой корутины
 */
abstract class CoroutineViewModel : SavedStateViewModel() {

    protected abstract val errorHandler: ErrorHandler

    private val coroutineJobs: MutableMap<String, Job> = mutableMapOf()

    /**
     * Перехватить и обработать с помощью [errorHandler] все ошибки, возникшие во [FlowResponse].
     *
     * @return исходный [FlowResponse]
     */
    protected fun <T> FlowResponse<T>.handleErrors(): FlowResponse<T> = onEach(::handleErrorIfHas)

    /**
     * Запустить корутину, чтобы начать получать данные из [Flow].
     *
     * @param context контект корутины
     *
     * @return новый [Job] запущенной корутины, либо уже существующий [Job] корутины, если она была запущена ранее
     */
    protected fun <T> Flow<T>.launchIn(context: CoroutineContext): Job = launch(context) { collect() }

    /**
     * Запустить во view model корутину через [CoroutineScope.launch].
     *
     * @param context контекст корутины
     * @param start тип запуска корутины
     * @param block блок кода корутины
     *
     * @return новый [Job] запущенной корутины, либо уже существующий [Job] корутины, если она была запущена ранее
     */
    protected fun launch(
        context: CoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        val coroutineName: String = context.getCoroutineName()
        return getExistedJobIfHas(coroutineName)
            ?: viewModelScope.launch(context, start, block).also { coroutineJobs[coroutineName] = it }
    }

    /**
     * Запустить во view model корутину через [CoroutineScope.async].
     *
     * @param context контекст корутины
     * @param start тип запуска корутины
     * @param block блок кода корутины
     *
     * @return новый [Job] запущенной корутины, либо уже существующий [Job] корутины, если она была запущена ранее
     */
    @Suppress("UNCHECKED_CAST")
    protected fun <T> async(
        context: CoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> T
    ): Deferred<T> {
        val coroutineName: String = context.getCoroutineName()
        return getExistedJobIfHas(coroutineName) as? Deferred<T>
            ?: viewModelScope.async(context, start, block).also { coroutineJobs[coroutineName] = it }
    }

    private fun CoroutineContext.getCoroutineName(): String =
        get(CoroutineName)?.name
            ?: throw IllegalStateException("All view model coroutines must have CoroutineName")

    private fun getExistedJobIfHas(coroutineName: String): Job? =
        coroutineJobs[coroutineName]?.let { existedJob ->
            if (existedJob.isActive) {
                existedJob
            } else {
                coroutineJobs.remove(coroutineName)
                null
            }
        }

    private fun handleErrorIfHas(state: Response<*>) {
        if (state.isError) errorHandler.handleError(state.getError())
    }
}