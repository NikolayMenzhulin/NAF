package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.SingleActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.SingleActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.QuizChoosingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.component.deps_provider.QuizChoosingFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module.QuizChoosingFragmentModule
import dagger.Component

/**
 * Component for [QuizChoosingFragment].
 */
@PerFragment
@Component(dependencies = [SingleActivityDepsProvider::class], modules = [QuizChoosingFragmentModule::class])
interface QuizChoosingFragmentComponent : ViewComponent<QuizChoosingFragment>, QuizChoosingFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: QuizChoosingFragmentModule): QuizChoosingFragmentComponent =
            DaggerQuizChoosingFragmentComponent.builder()
                .singleActivityDepsProvider(SingleActivityComponentHolder.component)
                .quizChoosingFragmentModule(module)
                .build()
    }
}