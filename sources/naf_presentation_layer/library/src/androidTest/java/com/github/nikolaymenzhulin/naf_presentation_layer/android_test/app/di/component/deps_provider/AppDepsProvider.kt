package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

interface AppDepsProvider {

    fun provideDefaultErrorHandler(): ErrorHandler
    fun provideRouter(): Router
    fun provideNavigatorHolder(): NavigatorHolder
}