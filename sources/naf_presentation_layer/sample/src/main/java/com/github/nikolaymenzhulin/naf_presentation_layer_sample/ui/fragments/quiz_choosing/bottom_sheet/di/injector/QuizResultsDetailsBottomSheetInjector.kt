package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.QuizResultsDetailsBottomSheet
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.holder.QuizResultsDetailsBottomSheetComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.module.QuizResultsDetailsBottomSheetModule

/**
 * Injector for [QuizResultsDetailsBottomSheet].
 */
class QuizResultsDetailsBottomSheetInjector(
    private val view: QuizResultsDetailsBottomSheet
) : AbstractViewInjector<QuizResultsDetailsBottomSheet>(view) {

    override fun initComponent() {
        QuizResultsDetailsBottomSheetComponentHolder.initComponent(QuizResultsDetailsBottomSheetModule(view))
    }

    override fun getViewComponent(): ViewComponent<QuizResultsDetailsBottomSheet> =
        QuizResultsDetailsBottomSheetComponentHolder.component

    override fun clearComponent() {
        QuizResultsDetailsBottomSheetComponentHolder.clearComponent()
    }
}