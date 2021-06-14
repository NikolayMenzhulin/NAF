/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.CoroutineViewModelTest.Companion.EXPECTED_EXCEPTION
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler.CoroutineActivityErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler.CoroutineActivityErrorHandler.Companion.CUSTOM_HANDLER
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.CoroutineViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Named

class TestCoroutineActivityViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    @Named(CUSTOM_HANDLER) override val errorHandler: CoroutineActivityErrorHandler
) : CoroutineViewModel() {

    private val _launchJob: MutableStateFlow<Job?> = MutableStateFlow(null)
    val launchJob: StateFlow<Job?> = _launchJob.asStateFlow()

    private val _asyncJob: MutableStateFlow<Deferred<Unit>?> = MutableStateFlow(null)
    val asyncJob: StateFlow<Deferred<Unit>?> = _asyncJob.asStateFlow()

    private val _launchInJob: MutableStateFlow<Job?> = MutableStateFlow(null)
    val launchInJob: StateFlow<Job?> = _launchInJob.asStateFlow()

    fun startCoroutineByLaunch() {
        launch(CoroutineName("LaunchCoroutine")) { delay(1000L) }.also(_launchJob::tryEmit)
    }

    fun startCoroutineByAsync() {
        launch(CoroutineName("LaunchForAsync")) {
            val job: Deferred<Unit> = async(CoroutineName("AsyncCoroutine")) { delay(1000L) }
            _asyncJob.tryEmit(job)
            job.await()
        }
    }

    fun startCoroutineByLaunchIn() {
        createStringFlow()
            .launchIn(CoroutineName("LaunchInCoroutine"))
            .also(_launchInJob::tryEmit)
    }

    fun emitErrorFlowResponse() {
        createErrorFlowResponse()
            .handleErrors()
            .launchIn(CoroutineName("ErrorFlowResponse"))
    }

    private fun createErrorFlowResponse(): FlowResponse<String> =
        flow { emit(Response.Error(error = EXPECTED_EXCEPTION)) }

    private fun createStringFlow(): Flow<String> =
        flow {
            delay(1000L)
            emit("String value.")
        }
}

@AssistedFactory
interface TestCoroutineActivityViewModelFactory : ViewModelAssistedFactory<TestCoroutineActivityViewModel>