package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.QuizResultsFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.component.QuizResultsFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [QuizResultsFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class QuizResultsFragmentModule(view: QuizResultsFragment) :
    FragmentModule<QuizResultsFragmentRoute>(QuizResultsFragmentRoute(view.arguments))