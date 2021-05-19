package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * Navigator for [MainActivity].
 */
class MainActivityNavigator @AssistedInject constructor(
    @Assisted override val vm: MainActivityViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<MainActivityViewModel>(commonDeps)

@AssistedFactory
interface MainActivityNavigatorFactory : NavigatorAssistedFactory<MainActivityNavigator, MainActivityViewModel>