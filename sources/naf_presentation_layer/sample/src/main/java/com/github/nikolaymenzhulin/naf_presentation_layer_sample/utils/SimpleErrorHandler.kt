package com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils

import com.github.nikolaymenzhulin.logger.Logger
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler

class SimpleErrorHandler : ErrorHandler {

    override fun handleError(error: Throwable) {
        Logger.e(error)
    }
}