package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.InjectableFragmentTest.Companion.DEPENDENCY_STRING
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragmentInjector.TestInjectableFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivityInjector.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.util.extensions.getActivityComponent
import dagger.Component
import dagger.Module
import dagger.Provides

class TestInjectableFragmentInjector(
    private val view: TestInjectableFragment,
    module: TestInjectableFragmentModule = TestInjectableFragmentModule()
) : AbstractViewInjector<TestInjectableFragment, TestInjectableFragmentModule>(view, module) {

    @PerFragment
    @Component(
        dependencies = [TestFragmentHostActivityComponent::class],
        modules = [TestInjectableFragmentModule::class]
    )
    interface TestInjectableFragmentComponent : ViewComponent<TestInjectableFragment>

    @Module
    class TestInjectableFragmentModule : DaggerModule {

        @PerFragment
        @Provides
        fun provideViewDependency(): String = DEPENDENCY_STRING
    }

    override fun getViewComponent(module: TestInjectableFragmentModule): ViewComponent<TestInjectableFragment> =
        DaggerTestInjectableFragmentInjector_TestInjectableFragmentComponent.builder()
            .testFragmentHostActivityComponent(view.getActivityComponent<TestFragmentHostActivity, TestFragmentHostActivityComponent>())
            .testInjectableFragmentModule(module)
            .build()
}