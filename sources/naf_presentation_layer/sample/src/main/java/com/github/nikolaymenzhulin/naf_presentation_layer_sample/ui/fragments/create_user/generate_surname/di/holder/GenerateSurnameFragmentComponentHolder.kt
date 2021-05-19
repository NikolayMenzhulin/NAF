package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.component.GenerateSurnameFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.GenerateSurnameFragmentModule

/**
 * ComponentHolder for [GenerateSurnameFragmentComponent].
 */
object GenerateSurnameFragmentComponentHolder :
    AbstractComponentHolder<GenerateSurnameFragmentComponent, GenerateSurnameFragmentModule>() {

    override fun getComponentImpl(module: GenerateSurnameFragmentModule): GenerateSurnameFragmentComponent =
        GenerateSurnameFragmentComponent.create(module)
}