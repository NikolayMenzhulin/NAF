package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestErrorHandlingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler.ErrorHandlingActivityErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelFactoryModule::class])
class TestErrorHandlingActivityModule(private val activity: TestErrorHandlingActivity) : DaggerModule {

    @PerActivity
    @Provides
    fun provideErrorHandler(): ErrorHandler = ErrorHandlingActivityErrorHandler(activity)
}