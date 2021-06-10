package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestCoroutineActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler

class CoroutineActivityErrorHandler(private val activity: TestCoroutineActivity) : ErrorHandler {

    companion object {

        const val CUSTOM_HANDLER = "ErrorHandlingActivityErrorHandler"
    }

    override fun handleError(error: Throwable) {
        activity.printErrorClassName(error)
    }
}