package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import kotlinx.coroutines.flow.onEach

/**
 * Базовый класс view model c поддержкой обработки ошибок.
 *
 * @param commonDeps основные зависимости, которые необходимы view model
 *
 * @property savedStateHandle [SavedStateHandle], связанный c view
 * @property errorHandler дефолтный обработчик ошибок
 */
abstract class ErrorHandlingViewModel(commonDeps: CommonViewModelDeps) : BaseViewModel() {

    protected val savedStateHandle: SavedStateHandle = commonDeps.savedStateHandle

    protected open val errorHandler: ErrorHandler = commonDeps.defaultErrorHandler

    /**
     * Перехватить и обработать с помощью [errorHandler] все ошибки, возникшие в [FlowResponse].
     */
    protected fun <T> FlowResponse<T>.handleErrors(): FlowResponse<T> = onEach(::handleErrorIfHas)

    private fun handleErrorIfHas(state: Response<*>) {
        if (state.isError) errorHandler.handleError(state.getError())
    }
}