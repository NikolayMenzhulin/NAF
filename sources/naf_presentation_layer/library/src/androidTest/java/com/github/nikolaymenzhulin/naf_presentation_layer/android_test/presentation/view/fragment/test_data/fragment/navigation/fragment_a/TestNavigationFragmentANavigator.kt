package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R
import com.github.nikolaymenzhulin.naf_presentation_layer.util.constants.EXTRA_FIRST
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestNavigationFragmentANavigator @AssistedInject constructor(
    @Assisted override val vm: TestNavigationFragmentAViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<TestNavigationFragmentAViewModel>(commonDeps) {

    init {
        observeFragmentBScreenResult()
    }

    fun goToFragmentB() {
        navController.navigate(R.id.action_fragment_a_to_fragment_b)
    }

    private fun observeFragmentBScreenResult() {
        getNavigationResultFlow<String>(EXTRA_FIRST)?.let {
            vm.setNavigationResult(navigationResult = it)
        }
    }
}

@AssistedFactory
interface TestNavigationFragmentANavigatorFactory :
    NavigatorAssistedFactory<TestNavigationFragmentANavigator, TestNavigationFragmentAViewModel>