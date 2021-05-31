package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.SingleActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.SingleActivityRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.SingleActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [SingleActivityComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class SingleActivityModule(view: SingleActivity) :
    ActivityModule<SingleActivityRoute>(SingleActivityRoute(view.intent))