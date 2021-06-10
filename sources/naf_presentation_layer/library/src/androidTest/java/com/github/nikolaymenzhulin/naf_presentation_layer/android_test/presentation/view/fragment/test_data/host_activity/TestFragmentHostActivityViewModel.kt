package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestFragmentHostActivityViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: TestFragmentHostActivityNavDelegate
) : AbstractViewModel<TestFragmentHostActivityNavDelegate>() {

    fun <R : AbstractFragmentRoute<*>> openFragmentScreen(route: R) {
        navDelegate.openFragmentScreen(route)
    }
}

@AssistedFactory
interface TestFragmentHostActivityViewModelFactory : ViewModelAssistedFactory<TestFragmentHostActivityViewModel>