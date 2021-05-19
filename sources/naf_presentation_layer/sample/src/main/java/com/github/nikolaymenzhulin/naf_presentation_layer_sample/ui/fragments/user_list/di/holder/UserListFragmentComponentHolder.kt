package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.component.UserListFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.UserListFragmentModule

/**
 * ComponentHolder for [UserListFragmentComponent].
 */
object UserListFragmentComponentHolder : AbstractComponentHolder<UserListFragmentComponent, UserListFragmentModule>() {

    override fun getComponentImpl(module: UserListFragmentModule): UserListFragmentComponent =
        UserListFragmentComponent.create(module)
}