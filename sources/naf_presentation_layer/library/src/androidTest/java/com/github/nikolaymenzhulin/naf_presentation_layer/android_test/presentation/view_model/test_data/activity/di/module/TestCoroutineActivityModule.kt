package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestCoroutineActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler.CoroutineActivityErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler.CoroutineActivityErrorHandler.Companion.CUSTOM_HANDLER
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [ViewModelFactoryModule::class])
class TestCoroutineActivityModule(private val view: TestCoroutineActivity) : DaggerModule {

    @PerActivity
    @Provides
    @Named(CUSTOM_HANDLER)
    fun provideErrorHandler(): CoroutineActivityErrorHandler = CoroutineActivityErrorHandler(view)
}