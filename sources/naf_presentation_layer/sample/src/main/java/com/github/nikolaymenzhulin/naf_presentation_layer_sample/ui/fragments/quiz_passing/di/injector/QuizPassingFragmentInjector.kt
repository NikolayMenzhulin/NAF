package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.QuizPassingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.holder.QuizPassingFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module.QuizPassingFragmentModule

/**
 * Injector for [QuizPassingFragment].
 */
class QuizPassingFragmentInjector(
    private val view: QuizPassingFragment
) : AbstractViewInjector<QuizPassingFragment>(view) {

    override fun initComponent() {
        QuizPassingFragmentComponentHolder.initComponent(QuizPassingFragmentModule(view))
    }

    override fun getViewComponent(): ViewComponent<QuizPassingFragment> =
        QuizPassingFragmentComponentHolder.component

    override fun clearComponent() {
        QuizPassingFragmentComponentHolder.clearComponent()
    }
}