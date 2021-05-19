package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler

/**
 * Базовый интерфейс обработчика ошибок.
 */
interface ErrorHandler {

    /**
     * Обработать полученную ошибку.
     *
     * @param error ошибка для обработки
     */
    fun handleError(error: Throwable)
}