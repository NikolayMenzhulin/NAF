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
 * The base class of a view model that contains the logic for working with coroutines.
 *
 * @property errorHandler the error handler for a view model
 * @property coroutineJobs a map, where the key is the name of the coroutine launched in the view model, and the value is the [Job] of this coroutine
 */
abstract class CoroutineViewModel : SavedStateViewModel() {

    protected abstract val errorHandler: ErrorHandler

    private val coroutineJobs: MutableMap<String, Job> = mutableMapOf()

    /**
     * Catch and handle with the [errorHandler] any errors that occur in the [FlowResponse].
     *
     * @return the original [FlowResponse]
     */
    protected fun <T> FlowResponse<T>.handleErrors(): FlowResponse<T> = onEach(::handleErrorIfHas)

    /**
     * Run the coroutine to start receiving the data from the [Flow].
     *
     * @param context the coroutine context
     *
     * @return a new [Job] of the running coroutine, or an already existing [Job] coroutine, if it was launched earlier
     */
    protected fun <T> Flow<T>.launchIn(context: CoroutineContext): Job = launch(context) { collect() }

    /**
     * Run the coroutine in a view model via [CoroutineScope.launch].
     *
     * @param context the coroutine context
     * @param start the coroutine launch type
     * @param block the coroutine code
     *
     * @return a new [Job] of the running coroutine, or an already existing [Job] coroutine, if it was launched earlier
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
     * Run the coroutine in a view model via [CoroutineScope.async].
     *
     * @param context the coroutine context
     * @param start the coroutine launch type
     * @param block the coroutine code
     *
     * @return a new [Job] of the running coroutine, or an already existing [Job] coroutine, if it was launched earlier
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