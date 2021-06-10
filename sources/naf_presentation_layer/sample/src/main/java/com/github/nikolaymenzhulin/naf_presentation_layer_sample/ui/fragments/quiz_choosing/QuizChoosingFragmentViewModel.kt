package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.QuizResultsStorage
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.holder.QuizPassingComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.di.module.QuizPassingModule
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for [QuizChoosingFragment].
 */
class QuizChoosingFragmentViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: QuizChoosingFragmentNavDelegate,
    private val quizResultsStorage: QuizResultsStorage
) : AbstractViewModel<QuizChoosingFragmentNavDelegate>() {

    private val _quizResultsList: MutableStateFlow<MutableList<QuizResults>> =
        MutableStateFlow(
            quizResultsStorage.getAll().toMutableList()
        )
    val quizResultsList: StateFlow<List<QuizResults>> = _quizResultsList.asStateFlow()

    fun deleteQuizResults() {
        observeQuizResultsDeletionResult()
        navDelegate.goToDeleteQuizResultsDialog()
    }

    fun goToQuizResultsDetails(quizResults: QuizResults) {
        navDelegate.goToQuizResultsDetails(quizResults)
    }

    fun goToQuizPassingFlow(difficulty: QuizDifficultyType) {
        observeQuizPassingFlowResult()
        QuizPassingComponentHolder.initComponent(QuizPassingModule())
        navDelegate.goToQuizPassingFlow(difficulty)
    }

    fun clearQuizPassingComponent() {
        QuizPassingComponentHolder.clearComponent()
    }

    private fun observeQuizResultsDeletionResult() {
        launch(CoroutineName("ObserveQuizResultsDeletionResult")) {
            val wasQuizResultsDeleted: Boolean = navDelegate.getQuizResultsDeletionResult()
            if (wasQuizResultsDeleted) _quizResultsList.tryEmit(mutableListOf())
        }
    }

    private fun observeQuizPassingFlowResult() {
        launch(CoroutineName("ObserveQuizPassingFlowResult")) {
            val quizResults: QuizResults = navDelegate.getQuizPassingFlowResult()
            val existedQuizResultsIndex: Int = _quizResultsList.value.indexOfFirst { it.id == quizResults.id }
            with(_quizResultsList.value) {
                if (existedQuizResultsIndex != -1) removeAt(existedQuizResultsIndex)
                add(quizResults)
            }
            quizResultsStorage.put(key = quizResults.id, data = quizResults)
        }
    }
}

@AssistedFactory
interface QuizChoosingFragmentViewModelFactory : ViewModelAssistedFactory<QuizChoosingFragmentViewModel>