package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractDialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.DialogDeleteQuizResultsBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.injector.DeleteQuizResultsDialogInjector

/**
 * The dialog for confirmation of deletion of all quiz results.
 */
class DeleteQuizResultsDialog : AbstractDialogFragment<DeleteQuizResultsDialogViewModel, DialogDeleteQuizResultsBinding>(
    DialogDeleteQuizResultsBinding::class.java
) {

    override val vm: DeleteQuizResultsDialogViewModel by viewModels()

    override val injector = DeleteQuizResultsDialogInjector(this)

    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initListeners()
    }

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }

    private fun initListeners() {
        vb.positiveBtn.setOnClickListener { vm.deleteQuizResults() }
        vb.negativeBtn.setOnClickListener { vm.exit() }
    }
}