package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.MainActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.MainActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.deps_provider.CreateUserDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.module.CreateUserModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.scope.PerCreateUser
import dagger.Component

/**
 * The component used when creating a new user.
 */
@PerCreateUser
@Component(dependencies = [MainActivityDepsProvider::class], modules = [CreateUserModule::class])
interface CreateUserComponent : DaggerComponent, CreateUserDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: CreateUserModule): CreateUserComponent =
            DaggerCreateUserComponent.builder()
                .mainActivityDepsProvider(MainActivityComponentHolder.component)
                .createUserModule(module)
                .build()
    }
}