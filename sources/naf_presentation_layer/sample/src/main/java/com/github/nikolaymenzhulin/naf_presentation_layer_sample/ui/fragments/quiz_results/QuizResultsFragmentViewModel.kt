package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils.QuizHolder
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [QuizResultsFragment].
 */
class QuizResultsFragmentViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: QuizResultsFragmentNavDelegate,
    quizHolder: QuizHolder
) : AbstractViewModel<QuizResultsFragmentNavDelegate>() {

    val quiz: Quiz = quizHolder.quiz!!

    fun backToQuizChoosing() {
        val quizResults: QuizResults = QuizResults.fromPassedQuiz(quiz)
        navDelegate.backToQuizChoosing(quizResults)
    }
}

@AssistedFactory
interface QuizResultsFragmentViewModelFactory : ViewModelAssistedFactory<QuizResultsFragmentViewModel>