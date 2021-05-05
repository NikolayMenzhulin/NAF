package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.TestNavigationFragmentAInjector.TestNavigationFragmentAModule
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

class TestNavigationFragmentAInjector(
    private val view: TestNavigationFragmentA,
    module: TestNavigationFragmentAModule = TestNavigationFragmentAModule(view)
) : AbstractViewInjector<TestNavigationFragmentA, TestNavigationFragmentAModule>(view, module) {

    @PerFragment
    @Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestNavigationFragmentAModule::class])
    interface TestNavigationFragmentAComponent : ViewComponent<TestNavigationFragmentA>

    @Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
    class TestNavigationFragmentAModule(fragment: TestNavigationFragmentA) : FragmentModule(fragment) {

        @PerFragment
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestNavigationFragmentAViewModelFactory>

    @Module
    interface NavigatorFactoryModule :
        BaseNavigatorFactoryModule<TestNavigationFragmentANavigatorFactory, TestNavigationFragmentANavigator, TestNavigationFragmentAViewModel>

    override fun getViewComponent(module: TestNavigationFragmentAModule): ViewComponent<TestNavigationFragmentA> =
        DaggerTestNavigationFragmentAInjector_TestNavigationFragmentAComponent.builder()
            .testFragmentHostActivityComponent(view.getActivityComponent<TestFragmentHostActivity, TestFragmentHostActivityComponent>())
            .testNavigationFragmentAModule(module)
            .build()
}