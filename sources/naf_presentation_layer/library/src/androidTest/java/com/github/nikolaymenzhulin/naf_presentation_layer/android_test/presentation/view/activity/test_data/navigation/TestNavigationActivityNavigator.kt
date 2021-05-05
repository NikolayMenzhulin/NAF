package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.NavigationActivityTest.Companion.NAVIGATION_RESULT_STRING
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestNavigationActivityNavigator @AssistedInject constructor(
    @Assisted override val vm: TestNavigationActivityViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<TestNavigationActivityViewModel>(commonDeps) {

    override fun onSetNavigationResult() {
        vm.setNavigationResult(NAVIGATION_RESULT_STRING)
    }

    fun goToFragmentB() {
        navController.navigate(R.id.action_fragment_a_to_fragment_b)
    }
}

@AssistedFactory
interface TestNavigationActivityNavigatorFactory :
    NavigatorAssistedFactory<TestNavigationActivityNavigator, TestNavigationActivityViewModel>