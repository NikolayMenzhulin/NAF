package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelFactoryModule::class])
class TestViewModelFragmentModule : DaggerModule {

    @PerFragment
    @Provides
    fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
}