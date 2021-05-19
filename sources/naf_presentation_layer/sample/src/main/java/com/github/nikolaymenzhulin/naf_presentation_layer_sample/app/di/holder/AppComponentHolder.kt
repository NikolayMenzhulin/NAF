package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.component.AppComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module.AppModule

/**
 * ComponentHolder for [AppComponent].
 */
object AppComponentHolder : AbstractComponentHolder<AppComponent, AppModule>() {

    override fun getComponentImpl(module: AppModule): AppComponent =
        AppComponent.create(module)
}