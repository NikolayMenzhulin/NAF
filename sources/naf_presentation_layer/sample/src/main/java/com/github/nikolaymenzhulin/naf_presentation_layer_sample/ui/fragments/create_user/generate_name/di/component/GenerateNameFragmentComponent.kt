package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.deps_provider.CreateUserDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.holder.CreateUserComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.GenerateNameFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.component.deps_provider.GenerateNameFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.GenerateNameFragmentModule
import dagger.Component

/**
 * Component for [GenerateNameFragment].
 */
@PerFragment
@Component(dependencies = [CreateUserDepsProvider::class], modules = [GenerateNameFragmentModule::class])
interface GenerateNameFragmentComponent : ViewComponent<GenerateNameFragment>, GenerateNameFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: GenerateNameFragmentModule): GenerateNameFragmentComponent =
            DaggerGenerateNameFragmentComponent.builder()
                .createUserDepsProvider(CreateUserComponentHolder.component)
                .generateNameFragmentModule(module)
                .build()
    }
}