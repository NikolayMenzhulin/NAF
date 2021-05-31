package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.component.deps_provider.SingleActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.SingleActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.QuizResultsDetailsBottomSheet
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.component.deps_provider.QuizResultsDetailsBottomSheetDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.di.module.QuizResultsDetailsBottomSheetModule
import dagger.Component

/**
 * Component for [QuizResultsDetailsBottomSheet].
 */
@PerDialog
@Component(dependencies = [SingleActivityDepsProvider::class], modules = [QuizResultsDetailsBottomSheetModule::class])
interface QuizResultsDetailsBottomSheetComponent : ViewComponent<QuizResultsDetailsBottomSheet>,
    QuizResultsDetailsBottomSheetDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: QuizResultsDetailsBottomSheetModule): QuizResultsDetailsBottomSheetComponent =
            DaggerQuizResultsDetailsBottomSheetComponent.builder()
                .singleActivityDepsProvider(SingleActivityComponentHolder.component)
                .quizResultsDetailsBottomSheetModule(module)
                .build()
    }
}