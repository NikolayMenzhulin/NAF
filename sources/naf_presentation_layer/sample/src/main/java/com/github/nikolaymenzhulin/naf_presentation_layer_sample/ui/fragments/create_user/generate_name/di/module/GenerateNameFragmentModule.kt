package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.GenerateNameFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.component.GenerateNameFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [GenerateNameFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class GenerateNameFragmentModule(fragment: GenerateNameFragment) : FragmentModule(fragment)