package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity

import androidx.lifecycle.viewModelScope
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.ErrorHandlingViewModelTest.Companion.EXPECTED_EXCEPTION
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.ErrorHandlingViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn

class TestErrorHandlingActivityViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps
) : ErrorHandlingViewModel(commonDeps) {

    fun emitErrorFlowResponse() {
        createErrorFlowResponse()
            .handleErrors()
            .launchIn(viewModelScope)
    }

    private fun createErrorFlowResponse(): FlowResponse<String> =
        flow { emit(Response.Error(error = EXPECTED_EXCEPTION)) }
}

@AssistedFactory
interface TestErrorHandlingActivityViewModelFactory : ViewModelAssistedFactory<TestErrorHandlingActivityViewModel>