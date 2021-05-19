package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.component.deps_provider.CreateUserDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.holder.CreateUserComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.component.deps_provider.GenerateAgeFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.GenerateAgeFragmentModule
import dagger.Component

/**
 * Component for [GenerateAgeFragment].
 */
@PerFragment
@Component(dependencies = [CreateUserDepsProvider::class], modules = [GenerateAgeFragmentModule::class])
interface GenerateAgeFragmentComponent : ViewComponent<GenerateAgeFragment>, GenerateAgeFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: GenerateAgeFragmentModule): GenerateAgeFragmentComponent =
            DaggerGenerateAgeFragmentComponent.builder()
                .createUserDepsProvider(CreateUserComponentHolder.component)
                .generateAgeFragmentModule(module)
                .build()
    }
}