package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.QuizChoosingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.QuizChoosingFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.component.QuizChoosingFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [QuizChoosingFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class QuizChoosingFragmentModule(view: QuizChoosingFragment) :
    FragmentModule<QuizChoosingFragmentRoute>(QuizChoosingFragmentRoute(view.arguments))