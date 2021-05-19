package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.CreateUserComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.module.CreateUserModule

/**
 * ComponentHolder for [CreateUserComponent].
 */
object CreateUserComponentHolder : AbstractComponentHolder<CreateUserComponent, CreateUserModule>() {

    override fun getComponentImpl(module: CreateUserModule): CreateUserComponent =
        CreateUserComponent.create(module)
}