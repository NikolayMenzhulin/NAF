package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.GenerateSurnameFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.component.GenerateSurnameFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [GenerateSurnameFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class GenerateSurnameFragmentModule(fragment: GenerateSurnameFragment) : FragmentModule(fragment)