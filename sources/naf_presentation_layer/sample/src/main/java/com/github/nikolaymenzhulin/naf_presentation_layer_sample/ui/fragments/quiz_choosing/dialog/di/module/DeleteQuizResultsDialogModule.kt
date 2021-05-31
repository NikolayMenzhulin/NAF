package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentDialogModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialog
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialogRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.component.DeleteQuizResultsDialogComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [DeleteQuizResultsDialogComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class DeleteQuizResultsDialogModule(view: DeleteQuizResultsDialog) :
    FragmentDialogModule<DeleteQuizResultsDialogRoute>(DeleteQuizResultsDialogRoute(view.arguments))