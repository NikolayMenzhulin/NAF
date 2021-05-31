package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [QuizResultsDetailsBottomSheet].
 */
@PerDialog
class QuizResultsDetailsBottomSheetNavDelegate @Inject constructor(
    override val router: Router,
    override val route: QuizResultsDetailsBottomSheetRoute
) : AbstractNavDelegate<Router, QuizResultsDetailsBottomSheetRoute>()