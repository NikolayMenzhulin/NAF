package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.deps_provider

import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.AppComponent

/**
 * DepsProvider for [AppComponent].
 */
interface AppDepsProvider {

    fun provideDefaultErrorHandler(): ErrorHandler
}