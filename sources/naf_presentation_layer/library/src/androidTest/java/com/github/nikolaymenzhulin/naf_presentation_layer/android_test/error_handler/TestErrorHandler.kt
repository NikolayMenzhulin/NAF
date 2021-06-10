package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.error_handler

import com.github.nikolaymenzhulin.logger.Logger
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler

class TestErrorHandler : ErrorHandler {

    override fun handleError(error: Throwable) {
        Logger.e(error)
    }
}