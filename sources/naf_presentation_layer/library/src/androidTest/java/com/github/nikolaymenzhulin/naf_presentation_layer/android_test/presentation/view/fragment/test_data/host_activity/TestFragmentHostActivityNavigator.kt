package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class TestFragmentHostActivityNavigator @AssistedInject constructor(
    @Assisted override val vm: TestFragmentHostActivityViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<TestFragmentHostActivityViewModel>(commonDeps)

@AssistedFactory
interface TestFragmentHostActivityNavigatorFactory :
    NavigatorAssistedFactory<TestFragmentHostActivityNavigator, TestFragmentHostActivityViewModel>