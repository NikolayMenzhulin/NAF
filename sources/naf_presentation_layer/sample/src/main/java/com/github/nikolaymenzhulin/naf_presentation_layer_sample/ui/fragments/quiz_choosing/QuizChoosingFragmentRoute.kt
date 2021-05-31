package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

/**
 * Route for [QuizChoosingFragment].
 */
class QuizChoosingFragmentRoute() : AbstractFragmentRoute<QuizChoosingFragment>() {

    constructor(args: Bundle?) : this()

    override fun getFragment(): QuizChoosingFragment = QuizChoosingFragment()
}