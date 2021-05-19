package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.MainActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.MainActivityModule

/**
 * ComponentHolder for [MainActivityComponent].
 */
object MainActivityComponentHolder : AbstractComponentHolder<MainActivityComponent, MainActivityModule>() {

    override fun getComponentImpl(module: MainActivityModule): MainActivityComponent =
        MainActivityComponent.create(module)
}