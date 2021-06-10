package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing

import android.os.Bundle
import androidx.core.os.bundleOf
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_SECOND
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType

/**
 * Route for [QuizPassingFragment].
 */
class QuizPassingFragmentRoute(
    val difficulty: QuizDifficultyType,
    val quizStageNumber: Int = 0
) : AbstractFragmentRoute<QuizPassingFragment>() {

    constructor(args: Bundle?) : this(
        args?.getSerializable(EXTRA_FIRST) as QuizDifficultyType,
        args.getInt(EXTRA_SECOND)
    )

    override fun getFragment(): QuizPassingFragment =
        QuizPassingFragment().apply {
            arguments = bundleOf(
                EXTRA_FIRST to difficulty,
                EXTRA_SECOND to quizStageNumber
            )
        }
}