package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.AppComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.scope.PerApp
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.SimpleErrorHandler
import dagger.Module
import dagger.Provides

/**
 * Module for [AppComponent].
 */
@Module
class AppModule : DaggerModule {

    @PerApp
    @Provides
    fun provideDefaultErrorHandler(): ErrorHandler = SimpleErrorHandler()
}