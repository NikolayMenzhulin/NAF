package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragmentRoute
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [QuizPassingFragment].
 */
@PerFragment
class QuizPassingFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: QuizPassingFragmentRoute
) : AbstractNavDelegate<Router, QuizPassingFragmentRoute>() {

    fun goToNextQuizStage() {
        router.navigateTo(
            QuizPassingFragmentRoute(
                difficulty = route.difficulty,
                quizStageNumber = route.quizStageNumber + 1
            )()
        )
    }

    fun goToQuizResults() {
        router.navigateTo(
            QuizResultsFragmentRoute()(
                enterAnimResId = R.anim.enter_overshoot,
                exitAnimResId = R.anim.exit,
                popEnterAnimResId = R.anim.pop_enter,
                popExitAnimResId = R.anim.pop_exit
            )
        )
    }
}