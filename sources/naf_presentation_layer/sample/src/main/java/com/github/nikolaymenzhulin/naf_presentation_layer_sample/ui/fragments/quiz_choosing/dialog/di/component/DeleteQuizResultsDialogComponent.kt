package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.SingleActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.SingleActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialog
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.component.deps_provider.DeleteQuizResultsDialogDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module.DeleteQuizResultsDialogModule
import dagger.Component

/**
 * Component for [DeleteQuizResultsDialog].
 */
@PerDialog
@Component(dependencies = [SingleActivityDepsProvider::class], modules = [DeleteQuizResultsDialogModule::class])
interface DeleteQuizResultsDialogComponent : ViewComponent<DeleteQuizResultsDialog>, DeleteQuizResultsDialogDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: DeleteQuizResultsDialogModule): DeleteQuizResultsDialogComponent =
            DaggerDeleteQuizResultsDialogComponent.builder()
                .singleActivityDepsProvider(SingleActivityComponentHolder.component)
                .deleteQuizResultsDialogModule(module)
                .build()
    }
}