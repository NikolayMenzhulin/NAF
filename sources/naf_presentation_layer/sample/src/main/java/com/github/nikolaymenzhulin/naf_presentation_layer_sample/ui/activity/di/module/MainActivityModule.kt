package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivityRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.MainActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [MainActivityComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class MainActivityModule(view: MainActivity) :
    ActivityModule<MainActivityRoute>(MainActivityRoute(view.intent))