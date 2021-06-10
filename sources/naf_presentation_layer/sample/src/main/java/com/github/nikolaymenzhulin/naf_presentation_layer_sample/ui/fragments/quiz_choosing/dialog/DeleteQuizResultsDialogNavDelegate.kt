package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [DeleteQuizResultsDialog].
 */
@PerDialog
class DeleteQuizResultsDialogNavDelegate @Inject constructor(
    override val router: Router,
    override val route: DeleteQuizResultsDialogRoute
) : AbstractNavDelegate<Router, DeleteQuizResultsDialogRoute>() {

    companion object {

        const val QUIZ_RESULTS_DELETION_RESULT = "QUIZ_DELETION_RESULT"
    }

    fun exitWithResults(wasQuizResultsDeleted: Boolean) {
        router.apply {
            sendResult(QUIZ_RESULTS_DELETION_RESULT, wasQuizResultsDeleted)
            exit()
        }
    }
}