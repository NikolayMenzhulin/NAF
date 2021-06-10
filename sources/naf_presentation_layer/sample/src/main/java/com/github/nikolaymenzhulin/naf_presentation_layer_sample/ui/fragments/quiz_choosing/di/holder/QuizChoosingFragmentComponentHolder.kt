package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.component.QuizChoosingFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module.QuizChoosingFragmentModule

/**
 * ComponentHolder for [QuizChoosingFragmentComponent].
 */
object QuizChoosingFragmentComponentHolder :
    AbstractComponentHolder<QuizChoosingFragmentComponent, QuizChoosingFragmentModule>() {

    override fun getComponentImpl(module: QuizChoosingFragmentModule): QuizChoosingFragmentComponent =
        QuizChoosingFragmentComponent.create(module)
}