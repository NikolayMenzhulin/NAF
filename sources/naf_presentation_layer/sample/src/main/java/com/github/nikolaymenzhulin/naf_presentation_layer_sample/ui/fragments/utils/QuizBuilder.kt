package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizAnswer
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizStage

@QuizDslMarker
class QuizBuilder(
    private val id: String,
    private val difficulty: QuizDifficultyType,
    private val stages: MutableList<QuizStage> = mutableListOf()
) {

    companion object {

        fun quiz(id: String, difficulty: QuizDifficultyType, block: QuizBuilder.() -> Unit): Quiz =
            QuizBuilder(id, difficulty).apply(block).build()
    }

    fun stage(questionText: String, block: QuizStageBuilder.() -> Unit) {
        QuizStageBuilder(questionText).apply(block).build().also(stages::add)
    }

    private fun build(): Quiz = Quiz(id, difficulty, stages)
}

@QuizDslMarker
class QuizStageBuilder(
    private val questionText: String,
    private val answers: MutableList<QuizAnswer> = mutableListOf()
) {

    fun answer(number: Int, answerText: String, isCorrect: Boolean = false) {
        QuizAnswerBuilder(number, answerText, isCorrect).build().also(answers::add)
    }

    fun build(): QuizStage = QuizStage(questionText, answers)
}

class QuizAnswerBuilder(
    private val number: Int,
    private val answerText: String,
    private val isCorrect: Boolean
) {

    fun build(): QuizAnswer = QuizAnswer(number, answerText, isCorrect)
}

@DslMarker
annotation class QuizDslMarker