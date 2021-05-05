package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestErrorHandlingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler

class ErrorHandlingActivityErrorHandler(private val activity: TestErrorHandlingActivity) : ErrorHandler {

    override fun handleError(error: Throwable) {
        activity.printErrorClassName(error)
    }
}