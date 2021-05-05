package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentInjector.TestViewBindingFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivityInjector.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.util.extensions.getActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Component
import dagger.Module
import dagger.Provides

class TestViewBindingFragmentInjector(
    private val view: TestViewBindingFragment,
    module: TestViewBindingFragmentModule = TestViewBindingFragmentModule()
) : AbstractViewInjector<TestViewBindingFragment, TestViewBindingFragmentModule>(view, module) {

    @PerFragment
    @Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestViewBindingFragmentModule::class])
    interface TestViewBindingFragmentComponent : ViewComponent<TestViewBindingFragment>

    @Module(includes = [ViewModelFactoryModule::class])
    class TestViewBindingFragmentModule : DaggerModule {

        @PerFragment
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestViewBindingFragmentViewModelFactory>

    override fun getViewComponent(module: TestViewBindingFragmentModule): ViewComponent<TestViewBindingFragment> =
        DaggerTestViewBindingFragmentInjector_TestViewBindingFragmentComponent.builder()
            .testFragmentHostActivityComponent(view.getActivityComponent<TestFragmentHostActivity, TestFragmentHostActivityComponent>())
            .testViewBindingFragmentModule(module)
            .build()
}