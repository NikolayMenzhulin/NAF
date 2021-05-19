package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.component.GenerateAgeFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [GenerateAgeFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class GenerateAgeFragmentModule(view: GenerateAgeFragment) :
    FragmentModule<GenerateAgeFragmentRoute>(GenerateAgeFragmentRoute(view.arguments))