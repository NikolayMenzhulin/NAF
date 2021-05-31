package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.DeleteQuizResultsDialogViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.dialog.di.module.DeleteQuizResultsDialogModule
import dagger.Module

/**
 * Submodule of [DeleteQuizResultsDialogModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<DeleteQuizResultsDialogViewModelFactory>