package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component.deps_provider.QuizPassingDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.holder.QuizPassingComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.QuizPassingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.component.deps_provider.QuizPassingFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module.QuizPassingFragmentModule
import dagger.Component

/**
 * Component for [QuizPassingFragment].
 */
@PerFragment
@Component(dependencies = [QuizPassingDepsProvider::class], modules = [QuizPassingFragmentModule::class])
interface QuizPassingFragmentComponent : ViewComponent<QuizPassingFragment>, QuizPassingFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: QuizPassingFragmentModule): QuizPassingFragmentComponent =
            DaggerQuizPassingFragmentComponent.builder()
                .quizPassingDepsProvider(QuizPassingComponentHolder.component)
                .quizPassingFragmentModule(module)
                .build()
    }
}