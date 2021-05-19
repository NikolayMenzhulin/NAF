package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.MainActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.MainActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.component.deps_provider.UserListFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.UserListFragmentModule
import dagger.Component

/**
 * Component for [UserListFragment].
 */
@PerFragment
@Component(dependencies = [MainActivityComponent::class], modules = [UserListFragmentModule::class])
interface UserListFragmentComponent : ViewComponent<UserListFragment>, UserListFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: UserListFragmentModule): UserListFragmentComponent =
            DaggerUserListFragmentComponent.builder()
                .mainActivityComponent(MainActivityComponentHolder.component)
                .userListFragmentModule(module)
                .build()
    }
}