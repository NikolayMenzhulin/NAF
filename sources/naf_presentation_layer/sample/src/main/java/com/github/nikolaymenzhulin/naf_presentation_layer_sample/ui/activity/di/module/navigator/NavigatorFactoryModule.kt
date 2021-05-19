package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.navigator

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseNavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivityNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivityNavigatorFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivityViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.MainActivityModule
import dagger.Module

/**
 * Submodule of [MainActivityModule].
 */
@Module
interface NavigatorFactoryModule :
    BaseNavigatorFactoryModule<MainActivityNavigatorFactory, MainActivityNavigator, MainActivityViewModel>