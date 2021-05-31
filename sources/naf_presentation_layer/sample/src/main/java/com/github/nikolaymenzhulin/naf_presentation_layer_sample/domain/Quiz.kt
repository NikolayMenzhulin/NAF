package com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain

/**
 * An Android quiz.
 *
 * @param id the id of the quiz
 * @param difficulty the [QuizDifficultyType] of the quiz
 * @param stages a list of [QuizStage] for the quiz
 */
data class Quiz(
    val id: String,
    val difficulty: QuizDifficultyType,
    val stages: List<QuizStage>
)