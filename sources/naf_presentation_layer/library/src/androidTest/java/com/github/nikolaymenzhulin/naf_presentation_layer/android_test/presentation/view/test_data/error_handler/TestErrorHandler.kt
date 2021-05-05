package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler

import com.github.nikolaymenzhulin.logger.Logger
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler

class TestErrorHandler : ErrorHandler {

    override fun handleError(error: Throwable) {
        Logger.e(error)
    }
}