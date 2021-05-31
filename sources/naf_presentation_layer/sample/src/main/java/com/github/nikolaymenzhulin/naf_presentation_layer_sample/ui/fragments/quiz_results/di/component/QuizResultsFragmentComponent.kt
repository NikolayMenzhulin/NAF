package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component.deps_provider.QuizPassingDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.holder.QuizPassingComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.component.deps_provider.QuizResultsFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module.QuizResultsFragmentModule
import dagger.Component

/**
 * Component for [QuizResultsFragment].
 */
@PerFragment
@Component(dependencies = [QuizPassingDepsProvider::class], modules = [QuizResultsFragmentModule::class])
interface QuizResultsFragmentComponent : ViewComponent<QuizResultsFragment>, QuizResultsFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: QuizResultsFragmentModule): QuizResultsFragmentComponent =
            DaggerQuizResultsFragmentComponent.builder()
                .quizPassingDepsProvider(QuizPassingComponentHolder.component)
                .quizResultsFragmentModule(module)
                .build()
    }
}