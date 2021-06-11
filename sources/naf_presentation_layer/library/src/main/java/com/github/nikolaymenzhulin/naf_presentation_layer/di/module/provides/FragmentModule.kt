package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import dagger.Module
import dagger.Provides

/**
 * The base Dagger module that provides basic dependencies for an fragment-based screen.
 */
@Module
abstract class FragmentModule<R : Route>(private val route: R) : DaggerModule {

    @PerFragment
    @Provides
    fun provideRoute(): R = route
}