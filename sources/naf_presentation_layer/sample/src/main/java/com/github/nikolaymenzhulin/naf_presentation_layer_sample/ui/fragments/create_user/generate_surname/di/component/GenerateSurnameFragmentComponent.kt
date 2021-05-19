package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.deps_provider.CreateUserDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.holder.CreateUserComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.GenerateSurnameFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.component.deps_provider.GenerateSurnameFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.GenerateSurnameFragmentModule
import dagger.Component

/**
 * Component for [GenerateSurnameFragment].
 */
@PerFragment
@Component(dependencies = [CreateUserDepsProvider::class], modules = [GenerateSurnameFragmentModule::class])
interface GenerateSurnameFragmentComponent : ViewComponent<GenerateSurnameFragment>, GenerateSurnameFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: GenerateSurnameFragmentModule): GenerateSurnameFragmentComponent =
            DaggerGenerateSurnameFragmentComponent.builder()
                .createUserDepsProvider(CreateUserComponentHolder.component)
                .generateSurnameFragmentModule(module)
                .build()
    }
}