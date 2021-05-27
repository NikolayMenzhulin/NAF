package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import dagger.Module
import dagger.Provides

/**
 * Базовый Dagger-модуль, предоставляющий основные зависимости для диалога, основанного на dialog fragment или bottom sheet fragment.
 */
@Module
abstract class FragmentDialogModule<R : Route>(private val route: R) : DaggerModule {

    @PerDialog
    @Provides
    fun provideRoute(): R = route
}