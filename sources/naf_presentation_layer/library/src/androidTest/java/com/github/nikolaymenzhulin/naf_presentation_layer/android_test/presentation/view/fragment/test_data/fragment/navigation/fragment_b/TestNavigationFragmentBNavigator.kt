package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.NavigationFragmentTest.Companion.NAVIGATION_RESULT_STRING
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.util.constants.EXTRA_FIRST
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestNavigationFragmentBNavigator @AssistedInject constructor(
    @Assisted override val vm: TestNavigationFragmentBViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<TestNavigationFragmentBViewModel>(commonDeps) {

    override fun onSetNavigationResult() {
        setNavigationResult(EXTRA_FIRST, NAVIGATION_RESULT_STRING)
    }
}

@AssistedFactory
interface TestNavigationFragmentBNavigatorFactory :
    NavigatorAssistedFactory<TestNavigationFragmentBNavigator, TestNavigationFragmentBViewModel>