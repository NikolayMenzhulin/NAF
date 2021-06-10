package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module

import android.content.Context
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.AppComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module.navigation.NavigationModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.scope.PerApp
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.QuizResultsStorage
import dagger.Module
import dagger.Provides

/**
 * Module for [AppComponent].
 */
@Module(includes = [NavigationModule::class])
class AppModule(private val context: Context) : DaggerModule {

    @PerApp
    @Provides
    fun provideQuizResultsStorage(): QuizResultsStorage =
        QuizResultsStorage(context.noBackupFilesDir.absolutePath)
}