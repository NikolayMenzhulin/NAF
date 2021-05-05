package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.InjectableActivityTest.Companion.DEPENDENCY_STRING
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.TestInjectableActivityInjector.TestInjectableActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component
import dagger.Module
import dagger.Provides

class TestInjectableActivityInjector(
    view: TestInjectableActivity,
    module: TestInjectableActivityModule = TestInjectableActivityModule()
) : AbstractViewInjector<TestInjectableActivity, TestInjectableActivityModule>(view, module) {

    @PerActivity
    @Component(modules = [TestInjectableActivityModule::class])
    interface TestInjectableActivityComponent : ViewComponent<TestInjectableActivity>

    @Module
    class TestInjectableActivityModule : DaggerModule {

        @PerActivity
        @Provides
        fun provideViewDependency(): String = DEPENDENCY_STRING
    }

    override fun getViewComponent(module: TestInjectableActivityModule): ViewComponent<TestInjectableActivity> =
        DaggerTestInjectableActivityInjector_TestInjectableActivityComponent.builder()
            .testInjectableActivityModule(module)
            .build()
}