package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a

import androidx.lifecycle.viewModelScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TestNavigationFragmentAViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps
) : AbstractViewModel(commonDeps) {

    private val _navigationResult: MutableStateFlow<String> = MutableStateFlow("")
    val navigationResult: StateFlow<String> = _navigationResult.asStateFlow()

    private val _navigatorHash: MutableStateFlow<String> = MutableStateFlow("")
    val navigatorHash: StateFlow<String> = _navigatorHash.asStateFlow()

    fun setNavigationResult(navigationResult: SharedFlow<String>) {
        viewModelScope.launch {
            _navigationResult.emitAll(navigationResult)
        }
    }

    fun setNavigatorHash(navigatorHash: String) {
        _navigatorHash.tryEmit(navigatorHash)
    }
}

@AssistedFactory
interface TestNavigationFragmentAViewModelFactory : ViewModelAssistedFactory<TestNavigationFragmentAViewModel>