package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module.AppModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.scope.PerApp
import dagger.Component

/**
 * Application component.
 */
@PerApp
@Component(modules = [AppModule::class])
interface AppComponent : DaggerComponent, AppDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: AppModule): AppComponent =
            DaggerAppComponent.builder()
                .appModule(module)
                .build()
    }
}