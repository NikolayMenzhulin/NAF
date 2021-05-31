package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractDialogFragmentRoute

/**
 * Route for [DeleteQuizResultsDialog].
 */
class DeleteQuizResultsDialogRoute() : AbstractDialogFragmentRoute<DeleteQuizResultsDialog>() {

    constructor(args: Bundle?) : this()

    override fun getDialog(): DeleteQuizResultsDialog = DeleteQuizResultsDialog()
}