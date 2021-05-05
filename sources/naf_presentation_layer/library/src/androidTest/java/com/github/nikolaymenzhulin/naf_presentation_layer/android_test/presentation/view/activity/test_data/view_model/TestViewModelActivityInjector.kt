package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivityInjector.TestViewModelActivityModule
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

class TestViewModelActivityInjector(
    view: TestViewModelActivity,
    module: TestViewModelActivityModule = TestViewModelActivityModule()
) : AbstractViewInjector<TestViewModelActivity, TestViewModelActivityModule>(view, module) {

    @PerActivity
    @Component(modules = [TestViewModelActivityModule::class])
    interface TestViewModelActivityComponent : ViewComponent<TestViewModelActivity>

    @Module(includes = [ViewModelFactoryModule::class])
    class TestViewModelActivityModule : DaggerModule {

        @PerActivity
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestViewModelActivityViewModelFactory>

    override fun getViewComponent(module: TestViewModelActivityModule): ViewComponent<TestViewModelActivity> =
        DaggerTestViewModelActivityInjector_TestViewModelActivityComponent.builder()
            .testViewModelActivityModule(module)
            .build()
}