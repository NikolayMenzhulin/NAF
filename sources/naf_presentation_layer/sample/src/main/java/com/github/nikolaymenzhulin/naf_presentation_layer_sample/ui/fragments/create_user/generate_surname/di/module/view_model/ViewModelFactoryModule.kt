package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.GenerateSurnameFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.GenerateSurnameFragmentModule
import dagger.Module

/**
 * Submodule of [GenerateSurnameFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<GenerateSurnameFragmentViewModelFactory>