package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialog
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.holder.DeleteQuizResultsDialogComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module.DeleteQuizResultsDialogModule

/**
 * Injector for [DeleteQuizResultsDialog].
 */
class DeleteQuizResultsDialogInjector(
    private val view: DeleteQuizResultsDialog
) : AbstractViewInjector<DeleteQuizResultsDialog>(view) {

    override fun initComponent() {
        DeleteQuizResultsDialogComponentHolder.initComponent(DeleteQuizResultsDialogModule(view))
    }

    override fun getViewComponent(): ViewComponent<DeleteQuizResultsDialog> =
        DeleteQuizResultsDialogComponentHolder.component

    override fun clearComponent() {
        DeleteQuizResultsDialogComponentHolder.clearComponent()
    }
}