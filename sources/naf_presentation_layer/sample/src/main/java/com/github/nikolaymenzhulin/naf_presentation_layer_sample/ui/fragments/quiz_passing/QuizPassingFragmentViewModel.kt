package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.Quiz
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizAnswer
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizStage
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils.QuizHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.utils.QuizProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for [QuizPassingFragment].
 */
class QuizPassingFragmentViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: QuizPassingFragmentNavDelegate,
    private val quizHolder: QuizHolder
) : AbstractViewModel<QuizPassingFragmentNavDelegate>() {

    private val quiz: Quiz = quizHolder.quiz ?: initQuiz()

    val stage: QuizStage = initStage()
    val isFinalStage: Boolean = quiz.stages.count { stage -> !stage.isCompleted } == 1

    private var _selectedAnswer: MutableStateFlow<QuizAnswer?> = MutableStateFlow(null)
    val selectedAnswer: StateFlow<QuizAnswer?> = _selectedAnswer.asStateFlow()

    fun onAnswerSelected(answer: QuizAnswer) {
        stage.answers.forEach { it.isSelected = false }
        answer.isSelected = true
        _selectedAnswer.tryEmit(answer)
    }

    fun onStageCompleted() {
        stage.apply {
            isCompleted = true
            isCompletedCorrectly = selectedAnswer.value!!.isCorrect
        }
        if (isFinalStage) {
            navDelegate.goToQuizResults()
        } else {
            navDelegate.goToNextQuizStage()
        }
    }

    private fun initQuiz(): Quiz {
        val difficulty: QuizDifficultyType = navDelegate.route.difficulty
        val quiz: Quiz = QuizProvider.getQuizByDifficulty(difficulty)
        quizHolder.quiz = quiz
        return quiz
    }

    private fun initStage(): QuizStage {
        val stage: QuizStage = quiz.stages[navDelegate.route.quizStageNumber]

        // Reset flags to default values if this stage has already been completed earlier
        if (stage.isCompleted) stage.isCompleted = false
        if (stage.isCompletedCorrectly) stage.isCompletedCorrectly = false
        return stage
    }
}

@AssistedFactory
interface QuizPassingFragmentViewModelFactory : ViewModelAssistedFactory<QuizPassingFragmentViewModel>