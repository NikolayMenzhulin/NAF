package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.component.GenerateAgeFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [GenerateAgeFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class GenerateAgeFragmentModule(fragment: GenerateAgeFragment) : FragmentModule(fragment)