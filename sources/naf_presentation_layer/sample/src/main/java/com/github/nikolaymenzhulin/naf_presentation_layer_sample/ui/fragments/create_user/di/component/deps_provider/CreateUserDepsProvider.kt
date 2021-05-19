package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.deps_provider

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.MainActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.CreateUserComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.UserGenerator

/**
 * DepsProvider for [CreateUserComponent].
 */
interface CreateUserDepsProvider : MainActivityDepsProvider {

    fun provideUserGenerator(): UserGenerator
}