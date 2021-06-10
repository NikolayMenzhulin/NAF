package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.SingleActivityViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.SingleActivityModule
import dagger.Module

/**
 * Submodule of [SingleActivityModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<SingleActivityViewModelFactory>