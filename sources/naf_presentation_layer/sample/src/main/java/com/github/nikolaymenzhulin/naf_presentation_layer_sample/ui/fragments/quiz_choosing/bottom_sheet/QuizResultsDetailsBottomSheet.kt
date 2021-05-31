package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractBottomSheetFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.BottomSheetQuizResultsDetailsBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.injector.QuizResultsDetailsBottomSheetInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.widget.QuizResultsDetailsView
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * The bottom sheet dialog with detailed info about the passed quiz.
 */
class QuizResultsDetailsBottomSheet :
    AbstractBottomSheetFragment<QuizResultsDetailsBottomSheetViewModel, BottomSheetQuizResultsDetailsBinding>(
        BottomSheetQuizResultsDetailsBinding::class.java
    ) {

    override val vm: QuizResultsDetailsBottomSheetViewModel by viewModels()

    override val injector = QuizResultsDetailsBottomSheetInjector(this)

    override fun onCreateDialogCallback(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialogCallback(savedInstanceState)
        (dialog as BottomSheetDialog).behavior.peekHeight = resources.displayMetrics.heightPixels
        return dialog
    }

    override fun onObserveViewModelCallback() {
        vm.passedQuiz.stages.forEach { stage ->
            val quizResultsDetailsV: QuizResultsDetailsView =
                QuizResultsDetailsView(requireContext()).apply {
                    setQuizResults(stage)
                }
            vb.contentContainer.addView(quizResultsDetailsV)
        }
    }
}