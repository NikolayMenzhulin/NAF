package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler

/**
 * The base interface of error handler.
 */
interface ErrorHandler {

    /**
     * Handle the received error.
     *
     * @param error the error for handling
     */
    fun handleError(error: Throwable)
}