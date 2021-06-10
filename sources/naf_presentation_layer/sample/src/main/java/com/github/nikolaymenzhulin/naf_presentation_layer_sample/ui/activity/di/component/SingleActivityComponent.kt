package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.SingleActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.SingleActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.SingleActivityModule
import dagger.Component

/**
 * Component for [SingleActivity].
 */
@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [SingleActivityModule::class])
interface SingleActivityComponent : ViewComponent<SingleActivity>, SingleActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: SingleActivityModule): SingleActivityComponent =
            DaggerSingleActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .singleActivityModule(module)
                .build()
    }
}