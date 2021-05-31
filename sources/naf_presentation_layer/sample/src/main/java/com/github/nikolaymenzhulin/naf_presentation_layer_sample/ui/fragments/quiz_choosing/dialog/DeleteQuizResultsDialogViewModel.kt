package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.QuizResultsStorage
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [DeleteQuizResultsDialog].
 */
class DeleteQuizResultsDialogViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: DeleteQuizResultsDialogNavDelegate,
    private val quizResultsStorage: QuizResultsStorage
) : AbstractViewModel<DeleteQuizResultsDialogNavDelegate>() {

    override fun exit() {
        navDelegate.exitWithResults(wasQuizResultsDeleted = false)
    }

    fun deleteQuizResults() {
        quizResultsStorage.clear()
        navDelegate.exitWithResults(wasQuizResultsDeleted = true)
    }
}

@AssistedFactory
interface DeleteQuizResultsDialogViewModelFactory : ViewModelAssistedFactory<DeleteQuizResultsDialogViewModel>