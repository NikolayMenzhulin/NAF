package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.QuizPassingFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module.QuizPassingFragmentModule
import dagger.Module

/**
 * Submodule of [QuizPassingFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<QuizPassingFragmentViewModelFactory>