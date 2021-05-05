package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivityInjector.TestViewBindingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Component
import dagger.Module
import dagger.Provides

class TestViewBindingActivityInjector(
    view: TestViewBindingActivity,
    module: TestViewBindingActivityModule = TestViewBindingActivityModule()
) : AbstractViewInjector<TestViewBindingActivity, TestViewBindingActivityModule>(view, module) {

    @PerActivity
    @Component(modules = [TestViewBindingActivityModule::class])
    interface TestViewBindingActivityComponent : ViewComponent<TestViewBindingActivity>

    @Module(includes = [ViewBindingFactoryModule::class])
    class TestViewBindingActivityModule : DaggerModule {

        @PerActivity
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewBindingFactoryModule : BaseViewModelFactoryModule<TestViewBindingActivityViewModelFactory>

    override fun getViewComponent(module: TestViewBindingActivityModule): ViewComponent<TestViewBindingActivity> =
        DaggerTestViewBindingActivityInjector_TestViewBindingActivityComponent.builder()
            .testViewBindingActivityModule(module)
            .build()
}