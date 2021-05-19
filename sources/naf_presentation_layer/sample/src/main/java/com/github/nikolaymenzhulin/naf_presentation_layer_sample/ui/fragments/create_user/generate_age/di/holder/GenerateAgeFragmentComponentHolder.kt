package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.component.GenerateAgeFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.GenerateAgeFragmentModule

/**
 * ComponentHolder for [GenerateAgeFragmentComponent].
 */
object GenerateAgeFragmentComponentHolder : AbstractComponentHolder<GenerateAgeFragmentComponent, GenerateAgeFragmentModule>() {

    override fun getComponentImpl(module: GenerateAgeFragmentModule): GenerateAgeFragmentComponent =
        GenerateAgeFragmentComponent.create(module)
}