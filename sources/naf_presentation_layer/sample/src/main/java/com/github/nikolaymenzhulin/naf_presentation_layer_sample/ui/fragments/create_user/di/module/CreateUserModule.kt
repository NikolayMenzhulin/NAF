package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.CreateUserComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.scope.PerCreateUser
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.UserGenerator
import dagger.Module
import dagger.Provides

/**
 * Module for [CreateUserComponent].
 */
@Module
class CreateUserModule : DaggerModule {

    @PerCreateUser
    @Provides
    fun provideUserGenerator(): UserGenerator = UserGenerator()
}