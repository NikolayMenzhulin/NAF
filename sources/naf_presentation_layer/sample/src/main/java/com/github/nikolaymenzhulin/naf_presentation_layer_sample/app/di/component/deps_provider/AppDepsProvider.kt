package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.deps_provider

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.AppComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.QuizResultsStorage
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

/**
 * DepsProvider for [AppComponent].
 */
interface AppDepsProvider {

    fun provideDefaultErrorHandler(): ErrorHandler
    fun provideRouter(): Router
    fun provideNavigatorHolder(): NavigatorHolder
    fun provideQuizResultsStorage(): QuizResultsStorage
}