package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.component.DeleteQuizResultsDialogComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module.DeleteQuizResultsDialogModule

/**
 * ComponentHolder for [DeleteQuizResultsDialogComponent].
 */
object DeleteQuizResultsDialogComponentHolder :
    AbstractComponentHolder<DeleteQuizResultsDialogComponent, DeleteQuizResultsDialogModule>() {

    override fun getComponentImpl(module: DeleteQuizResultsDialogModule): DeleteQuizResultsDialogComponent =
        DeleteQuizResultsDialogComponent.create(module)
}