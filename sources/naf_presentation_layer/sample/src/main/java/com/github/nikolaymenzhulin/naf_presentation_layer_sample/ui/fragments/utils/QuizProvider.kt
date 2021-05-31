package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils

import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType.*
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils.QuizBuilder.Companion.quiz

object QuizProvider {

    private const val EASY_QUIZ_ID = "Easy Quiz"
    private const val NORMAL_QUIZ_ID = "Normal Quiz"
    private const val HARD_QUIZ_ID = "Hard Quiz"

    private val easyQuiz: Quiz
        get() = quiz(id = EASY_QUIZ_ID, difficulty = EASY) {
            stage(questionText = "Choose a trait that characterizes only birds:") {
                answer(number = 0, answerText = "Reproduction by eggs")
                answer(number = 1, answerText = "Warm-bloodedness")
                answer(number = 2, answerText = "Double breathing", isCorrect = true)
            }
            stage(questionText = "Choose a trait that only characterizes mammals:") {
                answer(number = 0, answerText = "Body covered with hair", isCorrect = true)
                answer(number = 1, answerText = "They have a constant body temperature")
                answer(number = 2, answerText = "Intensive metabolism")
            }
            stage(questionText = "Marsupials are common on the mainland:") {
                answer(number = 0, answerText = "Australia", isCorrect = true)
                answer(number = 1, answerText = "Africa")
                answer(number = 2, answerText = "Eurasia")
            }
        }

    private val normalQuiz: Quiz
        get() = quiz(id = NORMAL_QUIZ_ID, difficulty = NORMAL) {
            stage(questionText = "What science studies the life processes in the body?") {
                answer(number = 0, answerText = "Anatomy")
                answer(number = 1, answerText = "Physiology", isCorrect = true)
                answer(number = 2, answerText = "Hygiene")
            }
            stage(questionText = "Human circulatory system:") {
                answer(number = 0, answerText = "Open")
                answer(number = 1, answerText = "Closed", isCorrect = true)
                answer(number = 2, answerText = "Diffuse")
            }
            stage(questionText = "Hereditary cell apparatus:") {
                answer(number = 0, answerText = "Core", isCorrect = true)
                answer(number = 1, answerText = "Vacuole")
                answer(number = 2, answerText = "Cytoplasm")
            }
        }

    private val hardQuiz: Quiz
        get() = quiz(id = HARD_QUIZ_ID, difficulty = HARD) {
            stage(questionText = "The heyday of trilobites occurred in:") {
                answer(number = 0, answerText = "Paleozoic era", isCorrect = true)
                answer(number = 1, answerText = "Proterozoic era")
                answer(number = 2, answerText = "Cenozoic era")
            }
            stage(questionText = "DNA monomer:") {
                answer(number = 0, answerText = "Glucose")
                answer(number = 1, answerText = "Amino acids")
                answer(number = 2, answerText = "Nucleotide", isCorrect = true)
            }
            stage(questionText = "Energy exchange includes:") {
                answer(number = 0, answerText = "Synthesis of organic substances")
                answer(number = 1, answerText = "Formation of complex substances from simple")
                answer(number = 2, answerText = "Decomposition of organic compounds", isCorrect = true)
            }
        }

    fun getQuizByDifficulty(difficulty: QuizDifficultyType): Quiz =
        when (difficulty) {
            EASY -> easyQuiz
            NORMAL -> normalQuiz
            HARD -> hardQuiz
        }

    fun getQuizById(id: String): Quiz? =
        when (id) {
            EASY_QUIZ_ID -> easyQuiz
            NORMAL_QUIZ_ID -> normalQuiz
            HARD_QUIZ_ID -> hardQuiz
            else -> null
        }
}