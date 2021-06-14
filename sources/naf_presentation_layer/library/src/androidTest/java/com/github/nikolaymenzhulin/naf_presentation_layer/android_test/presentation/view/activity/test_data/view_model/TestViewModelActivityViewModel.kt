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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.ViewModelActivityTest.Companion.CURRENT_NUMBER_INIT_VALUE
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.ViewModelActivityTest.Companion.SAVE_TAG
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModelActivityViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: TestViewModelActivityNavDelegate
) : AbstractViewModel<TestViewModelActivityNavDelegate>() {

    private val _currentNumber: MutableStateFlow<String> = MutableStateFlow(CURRENT_NUMBER_INIT_VALUE)
    val currentNumber: StateFlow<String> = _currentNumber.asStateFlow()

    override fun onSaveInstantState() {
        _currentNumber.tryEmit(_currentNumber.value + SAVE_TAG)
    }

    fun increaseCurrentNumber() {
        try {
            val increasedNumber: Int = _currentNumber.value.toInt() + 1
            _currentNumber.tryEmit(increasedNumber.toString())
        } catch (e: NumberFormatException) {
            errorHandler.handleError(e)
        }
    }
}

@AssistedFactory
interface TestViewModelActivityViewModelFactory : ViewModelAssistedFactory<TestViewModelActivityViewModel>