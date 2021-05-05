package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.TestNavigationFragmentBInjector.TestNavigationFragmentBModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivityInjector.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseNavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.util.extensions.getActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Component
import dagger.Module
import dagger.Provides

class TestNavigationFragmentBInjector(
    private val view: TestNavigationFragmentB,
    module: TestNavigationFragmentBModule = TestNavigationFragmentBModule(view)
) : AbstractViewInjector<TestNavigationFragmentB, TestNavigationFragmentBModule>(view, module) {

    @PerFragment
    @Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestNavigationFragmentBModule::class])
    interface TestNavigationFragmentBComponent : ViewComponent<TestNavigationFragmentB>

    @Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
    class TestNavigationFragmentBModule(fragment: TestNavigationFragmentB) : FragmentModule(fragment) {

        @PerFragment
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestNavigationFragmentBViewModelFactory>

    @Module
    interface NavigatorFactoryModule :
        BaseNavigatorFactoryModule<TestNavigationFragmentBNavigatorFactory, TestNavigationFragmentBNavigator, TestNavigationFragmentBViewModel>

    override fun getViewComponent(module: TestNavigationFragmentBModule): ViewComponent<TestNavigationFragmentB> =
        DaggerTestNavigationFragmentBInjector_TestNavigationFragmentBComponent.builder()
            .testFragmentHostActivityComponent(view.getActivityComponent<TestFragmentHostActivity, TestFragmentHostActivityComponent>())
            .testNavigationFragmentBModule(module)
            .build()
}