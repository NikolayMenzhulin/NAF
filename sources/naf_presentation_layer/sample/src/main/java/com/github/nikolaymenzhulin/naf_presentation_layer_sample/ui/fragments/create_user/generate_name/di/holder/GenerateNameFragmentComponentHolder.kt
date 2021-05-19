package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.component.GenerateNameFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.GenerateNameFragmentModule

/**
 * ComponentHolder for [GenerateNameFragmentComponent].
 */
object GenerateNameFragmentComponentHolder :
    AbstractComponentHolder<GenerateNameFragmentComponent, GenerateNameFragmentModule>() {

    override fun getComponentImpl(module: GenerateNameFragmentModule): GenerateNameFragmentComponent =
        GenerateNameFragmentComponent.create(module)
}