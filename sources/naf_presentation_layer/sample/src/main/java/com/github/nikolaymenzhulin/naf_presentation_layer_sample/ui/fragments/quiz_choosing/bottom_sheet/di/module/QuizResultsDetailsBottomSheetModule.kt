package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentDialogModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.QuizResultsDetailsBottomSheet
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.QuizResultsDetailsBottomSheetRoute
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.component.QuizResultsDetailsBottomSheetComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [QuizResultsDetailsBottomSheetComponent].
 */
@Module(includes = [ViewModelFactoryModule::class])
class QuizResultsDetailsBottomSheetModule(view: QuizResultsDetailsBottomSheet) :
    FragmentDialogModule<QuizResultsDetailsBottomSheetRoute>(QuizResultsDetailsBottomSheetRoute(view.arguments))