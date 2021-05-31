package com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizAnswer
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizStage
import java.io.Serializable

data class QuizResults(
    val id: String,
    val difficulty: QuizDifficultyType,
    val stagesCount: Int,
    val countCompletedCorrectlyStages: Int,
    val selectedAnswers: List<Int>
) : Serializable {

    companion object {

        fun fromPassedQuiz(quiz: Quiz): QuizResults {
            val selectedAnswers: List<Int> =
                mutableListOf<Int>().apply {
                    quiz.stages.forEach { stage ->
                        val selectedAnswerNumber: Int = stage.answers.first(QuizAnswer::isSelected).number
                        add(selectedAnswerNumber)
                    }
                }
            return QuizResults(
                id = quiz.id,
                difficulty = quiz.difficulty,
                stagesCount = quiz.stages.size,
                countCompletedCorrectlyStages = quiz.stages.count(QuizStage::isCompletedCorrectly),
                selectedAnswers = selectedAnswers
            )
        }
    }
}