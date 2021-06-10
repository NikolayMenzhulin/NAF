package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.QuizPassingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.QuizPassingFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.component.QuizPassingFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [QuizPassingFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class QuizPassingFragmentModule(view: QuizPassingFragment) :
    FragmentModule<QuizPassingFragmentRoute>(QuizPassingFragmentRoute(view.arguments))