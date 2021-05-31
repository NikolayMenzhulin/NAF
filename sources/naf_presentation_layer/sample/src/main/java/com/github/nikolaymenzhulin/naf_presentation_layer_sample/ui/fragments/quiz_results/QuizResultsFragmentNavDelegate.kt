package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.QuizChoosingFragmentRoute
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [QuizResultsFragment].
 */
@PerFragment
class QuizResultsFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: QuizResultsFragmentRoute
) : AbstractNavDelegate<Router, QuizResultsFragmentRoute>() {

    companion object {

        const val QUIZ_PASSING_FLOW_RESULT_KEY = "QUIZ_PASSING_FLOW_RESULT_KEY"
    }

    fun backToQuizChoosing(quizResults: QuizResults) {
        router.apply {
            sendResult(QUIZ_PASSING_FLOW_RESULT_KEY, quizResults)
            newRootScreen(
                QuizChoosingFragmentRoute()(
                    enterAnimResId = R.anim.enter
                )
            )
        }
    }
}