package com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain

/**
 * Types of difficulty for a quiz.
 *
 * @param id the id of type of difficulty
 * @param text the text value of type of difficulty
 *
 * @property EASY easy difficulty
 * @property NORMAL normal difficulty
 * @property HARD hard difficulty
 */
enum class QuizDifficultyType(private val id: Int, val text: String) {

    EASY(0, "Easy"),
    NORMAL(1, "Normal"),
    HARD(2, "Hard");

    companion object {

        fun getById(id: Int): QuizDifficultyType = values().first { it.id == id }
    }
}