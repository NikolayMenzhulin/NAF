package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivityInjector.TestFragmentHostActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseNavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Component
import dagger.Module
import dagger.Provides

class TestFragmentHostActivityInjector(
    view: TestFragmentHostActivity,
    module: TestFragmentHostActivityModule = TestFragmentHostActivityModule(view)
) : AbstractViewInjector<TestFragmentHostActivity, TestFragmentHostActivityModule>(view, module) {

    @PerActivity
    @Component(modules = [TestFragmentHostActivityModule::class])
    interface TestFragmentHostActivityComponent : ViewComponent<TestFragmentHostActivity>

    @Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
    class TestFragmentHostActivityModule(activity: TestFragmentHostActivity) : ActivityModule(activity, R.id.nav_host_fragment) {

        @PerActivity
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestFragmentHostActivityViewModelFactory>

    @Module
    interface NavigatorFactoryModule :
        BaseNavigatorFactoryModule<TestFragmentHostActivityNavigatorFactory, TestFragmentHostActivityNavigator, TestFragmentHostActivityViewModel>

    override fun getViewComponent(module: TestFragmentHostActivityModule): ViewComponent<TestFragmentHostActivity> =
        DaggerTestFragmentHostActivityInjector_TestFragmentHostActivityComponent.builder()
            .testFragmentHostActivityModule(module)
            .build()
}