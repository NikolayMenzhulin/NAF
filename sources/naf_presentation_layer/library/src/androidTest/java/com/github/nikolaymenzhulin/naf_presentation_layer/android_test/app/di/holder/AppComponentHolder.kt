package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.AppComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.module.AppModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder

object AppComponentHolder : AbstractComponentHolder<AppComponent, AppModule>() {

    override fun getComponentImpl(module: AppModule): AppComponent =
        AppComponent.create(module)
}