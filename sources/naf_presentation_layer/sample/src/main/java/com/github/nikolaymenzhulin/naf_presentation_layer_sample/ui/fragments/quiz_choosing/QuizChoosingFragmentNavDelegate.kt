package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.QuizResultsDetailsBottomSheetRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialogNavDelegate.Companion.QUIZ_RESULTS_DELETION_RESULT
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialogRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.QuizPassingFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragmentNavDelegate.Companion.QUIZ_PASSING_FLOW_RESULT_KEY
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [QuizChoosingFragment].
 */
@PerFragment
class QuizChoosingFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: QuizChoosingFragmentRoute
) : AbstractNavDelegate<Router, QuizChoosingFragmentRoute>() {

    fun goToDeleteQuizResultsDialog() {
        router.navigateTo(DeleteQuizResultsDialogRoute()())
    }

    suspend fun getQuizResultsDeletionResult(): Boolean =
        router.getScreenResult(QUIZ_RESULTS_DELETION_RESULT)

    fun goToQuizPassingFlow(difficulty: QuizDifficultyType) {
        router.navigateTo(QuizPassingFragmentRoute(difficulty)())
    }

    suspend fun getQuizPassingFlowResult(): QuizResults =
        router.getScreenResult(QUIZ_PASSING_FLOW_RESULT_KEY)

    fun goToQuizResultsDetails(quizResults: QuizResults) {
        router.navigateTo(QuizResultsDetailsBottomSheetRoute(quizResults)())
    }
}