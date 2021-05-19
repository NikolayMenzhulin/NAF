package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import dagger.Module
import dagger.Provides

/**
 * Базовый Dagger-модуль, предоставляющий основные зависимости для экрана, основанного на activity.
 */
@Module
abstract class ActivityModule<R : Route>(private val route: R) : DaggerModule {

    @PerActivity
    @Provides
    fun provideRoute(): R = route
}