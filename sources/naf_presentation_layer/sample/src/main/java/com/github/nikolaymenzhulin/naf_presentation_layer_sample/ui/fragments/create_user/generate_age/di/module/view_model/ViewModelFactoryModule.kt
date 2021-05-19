package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.GenerateAgeFragmentModule
import dagger.Module

/**
 * Submodule of [GenerateAgeFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<GenerateAgeFragmentViewModelFactory>