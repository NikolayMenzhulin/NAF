package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestViewBindingFragmentViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: TestViewBindingFragmentNavDelegate
) : AbstractViewModel<TestViewBindingFragmentNavDelegate>()

@AssistedFactory
interface TestViewBindingFragmentViewModelFactory : ViewModelAssistedFactory<TestViewBindingFragmentViewModel>