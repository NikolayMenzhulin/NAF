package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.component.QuizResultsFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module.QuizResultsFragmentModule

/**
 * ComponentHolder for [QuizResultsFragmentComponent].
 */
object QuizResultsFragmentComponentHolder : AbstractComponentHolder<QuizResultsFragmentComponent, QuizResultsFragmentModule>() {

    override fun getComponentImpl(module: QuizResultsFragmentModule): QuizResultsFragmentComponent =
        QuizResultsFragmentComponent.create(module)
}