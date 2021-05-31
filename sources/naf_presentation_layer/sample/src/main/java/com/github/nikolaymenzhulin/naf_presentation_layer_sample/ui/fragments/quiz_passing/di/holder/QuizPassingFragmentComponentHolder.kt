package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.component.QuizPassingFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module.QuizPassingFragmentModule

/**
 * ComponentHolder for [QuizPassingFragmentComponent].
 */
object QuizPassingFragmentComponentHolder : AbstractComponentHolder<QuizPassingFragmentComponent, QuizPassingFragmentModule>() {

    override fun getComponentImpl(module: QuizPassingFragmentModule): QuizPassingFragmentComponent =
        QuizPassingFragmentComponent.create(module)
}