package com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain

/**
 * An answer to a quiz question.
 *
 * @param number the number of the answer
 * @param answerText the text of the answer
 * @param isCorrect is the answer correct or not
 * @param isSelected is the answer selected
 */
data class QuizAnswer(
    val number: Int,
    val answerText: String,
    val isCorrect: Boolean,
    var isSelected: Boolean = false
)