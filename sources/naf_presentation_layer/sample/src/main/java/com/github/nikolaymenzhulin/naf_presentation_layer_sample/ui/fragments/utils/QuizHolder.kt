package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.scope.PerQuizPassing
import javax.inject.Inject

@PerQuizPassing
class QuizHolder @Inject constructor() {

    var quiz: Quiz? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }
}