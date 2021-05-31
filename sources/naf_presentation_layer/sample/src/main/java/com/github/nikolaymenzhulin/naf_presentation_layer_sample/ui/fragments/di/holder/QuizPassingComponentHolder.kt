package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.component.QuizPassingComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.module.QuizPassingModule

/**
 * ComponentHolder for [QuizPassingComponent].
 */
object QuizPassingComponentHolder : AbstractComponentHolder<QuizPassingComponent, QuizPassingModule>() {

    override fun getComponentImpl(module: QuizPassingModule): QuizPassingComponent =
        QuizPassingComponent.create(module)
}