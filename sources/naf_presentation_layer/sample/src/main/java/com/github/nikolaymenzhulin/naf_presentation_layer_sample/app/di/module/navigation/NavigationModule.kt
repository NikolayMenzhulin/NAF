package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module.navigation

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module.AppModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.scope.PerApp
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.SimpleErrorHandler
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

/**
 * Submodule of [AppModule].
 */
@Module
class NavigationModule {

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