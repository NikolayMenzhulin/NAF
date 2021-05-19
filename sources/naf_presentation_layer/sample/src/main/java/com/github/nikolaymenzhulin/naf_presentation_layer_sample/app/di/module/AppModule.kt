package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.AppComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.scope.PerApp
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.SimpleErrorHandler
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

/**
 * Module for [AppComponent].
 */
@Module
class AppModule : DaggerModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @PerApp
    @Provides
    fun provideDefaultErrorHandler(): ErrorHandler = SimpleErrorHandler()

    @PerApp
    @Provides
    fun provideRouter(): Router = cicerone.router

    @PerApp
    @Provides
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()
}