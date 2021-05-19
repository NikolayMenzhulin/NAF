package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.MainActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.MainActivityModule
import dagger.Component

/**
 * Component for [MainActivity].
 */
@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [MainActivityModule::class])
interface MainActivityComponent : ViewComponent<MainActivity>, MainActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: MainActivityModule): MainActivityComponent =
            DaggerMainActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .mainActivityModule(module)
                .build()
    }
}