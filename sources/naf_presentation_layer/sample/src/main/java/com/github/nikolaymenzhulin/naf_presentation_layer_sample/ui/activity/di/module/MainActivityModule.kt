package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.MainActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [MainActivityComponent].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class MainActivityModule(activity: MainActivity) : ActivityModule(activity, R.id.nav_host_fragment)