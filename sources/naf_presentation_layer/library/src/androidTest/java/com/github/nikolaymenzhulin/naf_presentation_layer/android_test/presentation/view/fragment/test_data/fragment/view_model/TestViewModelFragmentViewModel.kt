package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.ViewModelFragmentTest.Companion.CURRENT_NUMBER_INIT_VALUE
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.ViewModelFragmentTest.Companion.SAVE_TAG
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModelFragmentViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps
) : AbstractViewModel(commonDeps) {

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
interface TestViewModelFragmentViewModelFactory : ViewModelAssistedFactory<TestViewModelFragmentViewModel>