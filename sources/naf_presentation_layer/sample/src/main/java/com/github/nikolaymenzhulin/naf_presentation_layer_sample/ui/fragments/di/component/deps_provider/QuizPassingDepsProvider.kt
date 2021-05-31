package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component.deps_provider

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.SingleActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component.QuizPassingComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils.QuizHolder

/**
 * DepsProvider for [QuizPassingComponent].
 */
interface QuizPassingDepsProvider : SingleActivityDepsProvider {

    fun provideQuizHolder(): QuizHolder
}