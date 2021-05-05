package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestErrorHandlingActivityInjector.TestErrorHandlingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.error_handler.ErrorHandlingActivityErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Component
import dagger.Module
import dagger.Provides

class TestErrorHandlingActivityInjector(
    view: TestErrorHandlingActivity,
    module: TestErrorHandlingActivityModule = TestErrorHandlingActivityModule(view)
) : AbstractViewInjector<TestErrorHandlingActivity, TestErrorHandlingActivityModule>(view, module) {

    @PerActivity
    @Component(modules = [TestErrorHandlingActivityModule::class])
    interface TestErrorHandlingActivityComponent : ViewComponent<TestErrorHandlingActivity>

    @Module(includes = [ViewModelFactoryModule::class])
    class TestErrorHandlingActivityModule(private val activity: TestErrorHandlingActivity) : DaggerModule {

        @PerActivity
        @Provides
        fun provideErrorHandler(): ErrorHandler = ErrorHandlingActivityErrorHandler(activity)
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestErrorHandlingActivityViewModelFactory>

    override fun getViewComponent(module: TestErrorHandlingActivityModule): ViewComponent<TestErrorHandlingActivity> =
        DaggerTestErrorHandlingActivityInjector_TestErrorHandlingActivityComponent.builder()
            .testErrorHandlingActivityModule(module)
            .build()
}