package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.QuizChoosingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.holder.QuizChoosingFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module.QuizChoosingFragmentModule

/**
 * Injector for [QuizChoosingFragment].
 */
class QuizChoosingFragmentInjector(
    private val view: QuizChoosingFragment
) : AbstractViewInjector<QuizChoosingFragment>(view) {

    override fun initComponent() {
        QuizChoosingFragmentComponentHolder.initComponent(QuizChoosingFragmentModule(view))
    }

    override fun getViewComponent(): ViewComponent<QuizChoosingFragment> =
        QuizChoosingFragmentComponentHolder.component

    override fun clearComponent() {
        QuizChoosingFragmentComponentHolder.clearComponent()
    }
}