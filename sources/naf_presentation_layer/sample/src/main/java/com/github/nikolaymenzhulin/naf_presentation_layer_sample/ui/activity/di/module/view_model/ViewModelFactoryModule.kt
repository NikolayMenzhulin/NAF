package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivityViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.MainActivityModule
import dagger.Module

/**
 * Submodule of [MainActivityModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<MainActivityViewModelFactory>