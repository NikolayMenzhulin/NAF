package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.GenerateNameFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.GenerateNameFragmentModule
import dagger.Module

/**
 * Submodule of [GenerateNameFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<GenerateNameFragmentViewModelFactory>