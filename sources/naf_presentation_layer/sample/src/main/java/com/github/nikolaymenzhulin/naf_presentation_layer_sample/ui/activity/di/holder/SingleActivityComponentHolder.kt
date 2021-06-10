package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.SingleActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.SingleActivityModule

/**
 * ComponentHolder for [SingleActivityComponent].
 */
object SingleActivityComponentHolder : AbstractComponentHolder<SingleActivityComponent, SingleActivityModule>() {

    override fun getComponentImpl(module: SingleActivityModule): SingleActivityComponent =
        SingleActivityComponent.create(module)
}