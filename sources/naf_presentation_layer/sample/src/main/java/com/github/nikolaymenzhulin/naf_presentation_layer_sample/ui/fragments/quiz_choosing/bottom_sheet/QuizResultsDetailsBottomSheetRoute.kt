package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet

import android.os.Bundle
import androidx.core.os.bundleOf
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractDialogFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults

/**
 * Route for [QuizResultsDetailsBottomSheet].
 */
class QuizResultsDetailsBottomSheetRoute(
    val quizResults: QuizResults
) : AbstractDialogFragmentRoute<QuizResultsDetailsBottomSheet>() {

    constructor(args: Bundle?) : this(
        args?.getSerializable(EXTRA_FIRST) as QuizResults
    )

    override fun getDialog(): QuizResultsDetailsBottomSheet =
        QuizResultsDetailsBottomSheet().apply {
            arguments = bundleOf(EXTRA_FIRST to quizResults)
        }
}