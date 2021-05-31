package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module.QuizResultsFragmentModule
import dagger.Module

/**
 * Submodule of [QuizResultsFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<QuizResultsFragmentViewModelFactory>