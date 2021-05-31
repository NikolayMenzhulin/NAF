package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.component.QuizResultsDetailsBottomSheetComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.module.QuizResultsDetailsBottomSheetModule

/**
 * ComponentHolder for [QuizResultsDetailsBottomSheetComponent].
 */
object QuizResultsDetailsBottomSheetComponentHolder :
    AbstractComponentHolder<QuizResultsDetailsBottomSheetComponent, QuizResultsDetailsBottomSheetModule>() {

    override fun getComponentImpl(module: QuizResultsDetailsBottomSheetModule): QuizResultsDetailsBottomSheetComponent =
        QuizResultsDetailsBottomSheetComponent.create(module)
}