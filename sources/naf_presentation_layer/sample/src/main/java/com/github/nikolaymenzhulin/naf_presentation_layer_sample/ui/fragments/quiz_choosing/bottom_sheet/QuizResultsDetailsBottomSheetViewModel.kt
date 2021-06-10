package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils.QuizProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [QuizResultsDetailsBottomSheet].
 */
class QuizResultsDetailsBottomSheetViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: QuizResultsDetailsBottomSheetNavDelegate
) : AbstractViewModel<QuizResultsDetailsBottomSheetNavDelegate>() {

    val passedQuiz: Quiz = initQuiz()

    private fun initQuiz(): Quiz {
        val quizResults: QuizResults = navDelegate.route.quizResults
        val quiz: Quiz = QuizProvider.getQuizById(quizResults.id)!!
        quiz.apply {
            stages.forEachIndexed { index, stage ->
                val correctAnswerIndex: Int = stage.answers.indexOfFirst { it.isCorrect }
                val selectedAnswerIndex: Int = quizResults.selectedAnswers[index]
                stage.isCompletedCorrectly = selectedAnswerIndex == correctAnswerIndex
                stage.isCompleted = true
                stage.answers.forEach { answer ->
                    answer.isSelected = answer.number == selectedAnswerIndex
                }
            }
        }
        return quiz
    }
}

@AssistedFactory
interface QuizResultsDetailsBottomSheetViewModelFactory : ViewModelAssistedFactory<QuizResultsDetailsBottomSheetViewModel>