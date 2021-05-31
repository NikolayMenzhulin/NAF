package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.QuizChoosingFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module.QuizChoosingFragmentModule
import dagger.Module

/**
 * Submodule of [QuizChoosingFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<QuizChoosingFragmentViewModelFactory>