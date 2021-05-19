package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestViewBindingActivityViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: TestViewBindingActivityNavDelegate
) : AbstractViewModel<TestViewBindingActivityNavDelegate>()

@AssistedFactory
interface TestViewBindingActivityViewModelFactory : ViewModelAssistedFactory<TestViewBindingActivityViewModel>