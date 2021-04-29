package com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base

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