package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestNavigationActivityViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps
) : AbstractViewModel(commonDeps) {

    private val _navigationResult: MutableStateFlow<String> = MutableStateFlow("")
    val navigationResult: StateFlow<String> = _navigationResult.asStateFlow()

    private val _navigatorHash: MutableStateFlow<String> = MutableStateFlow("")
    val navigatorHash: StateFlow<String> = _navigatorHash.asStateFlow()

    fun setNavigationResult(navigationResult: String) {
        _navigationResult.tryEmit(navigationResult)
    }

    fun setNavigatorHash(navigatorHash: String) {
        _navigatorHash.tryEmit(navigatorHash)
    }
}

@AssistedFactory
interface TestNavigationActivityViewModelFactory : ViewModelAssistedFactory<TestNavigationActivityViewModel>