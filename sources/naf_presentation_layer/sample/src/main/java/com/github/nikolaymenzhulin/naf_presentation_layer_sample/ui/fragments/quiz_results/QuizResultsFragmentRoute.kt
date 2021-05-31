package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

/**
 * Route for [QuizResultsFragment].
 */
class QuizResultsFragmentRoute() : AbstractFragmentRoute<QuizResultsFragment>() {

    constructor(args: Bundle?) : this()

    override fun getFragment(): QuizResultsFragment = QuizResultsFragment()
}