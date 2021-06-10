package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.holder.QuizResultsFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module.QuizResultsFragmentModule

/**
 * Injector for [QuizResultsFragment].
 */
class QuizResultsFragmentInjector(
    private val view: QuizResultsFragment
) : AbstractViewInjector<QuizResultsFragment>(view) {

    override fun initComponent() {
        QuizResultsFragmentComponentHolder.initComponent(QuizResultsFragmentModule(view))
    }

    override fun getViewComponent(): ViewComponent<QuizResultsFragment> =
        QuizResultsFragmentComponentHolder.component

    override fun clearComponent() {
        QuizResultsFragmentComponentHolder.clearComponent()
    }
}