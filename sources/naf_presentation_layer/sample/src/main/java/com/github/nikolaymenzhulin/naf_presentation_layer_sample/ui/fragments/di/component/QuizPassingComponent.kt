package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.SingleActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.SingleActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component.deps_provider.QuizPassingDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.module.QuizPassingModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.scope.PerQuizPassing
import dagger.Component

/**
 * The component that provides dependencies during the quiz.
 */
@PerQuizPassing
@Component(dependencies = [SingleActivityDepsProvider::class], modules = [QuizPassingModule::class])
interface QuizPassingComponent : DaggerComponent, QuizPassingDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: QuizPassingModule): QuizPassingComponent =
            DaggerQuizPassingComponent.builder()
                .singleActivityDepsProvider(SingleActivityComponentHolder.component)
                .quizPassingModule(module)
                .build()
    }
}