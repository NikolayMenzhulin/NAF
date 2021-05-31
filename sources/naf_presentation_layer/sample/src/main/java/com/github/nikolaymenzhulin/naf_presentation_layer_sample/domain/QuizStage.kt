package com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain

/**
 * A single stage of a quiz.
 *
 * @param questionText the text of the question of this stage of the quiz
 * @param answers a list of answers to the question
 * @param isCompleted was the question been answered
 * @param isCompletedCorrectly was the question been answered correctly
 */
data class QuizStage(
    val questionText: String,
    val answers: List<QuizAnswer>,
    var isCompleted: Boolean = false,
    var isCompletedCorrectly: Boolean = false
)