package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.TestNavigationActivityInjector.TestNavigationActivityModule
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

class TestNavigationActivityInjector(
    view: TestNavigationActivity,
    module: TestNavigationActivityModule = TestNavigationActivityModule(view)
) : AbstractViewInjector<TestNavigationActivity, TestNavigationActivityModule>(view, module) {

    @PerActivity
    @Component(modules = [TestNavigationActivityModule::class])
    interface TestNavigationActivityComponent : ViewComponent<TestNavigationActivity>

    @Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
    class TestNavigationActivityModule(activity: TestNavigationActivity) : ActivityModule(activity, R.id.nav_host_fragment) {

        @PerActivity
        @Provides
        fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
    }

    @Module
    interface ViewModelFactoryModule : BaseViewModelFactoryModule<TestNavigationActivityViewModelFactory>

    @Module
    interface NavigatorFactoryModule :
        BaseNavigatorFactoryModule<TestNavigationActivityNavigatorFactory, TestNavigationActivityNavigator, TestNavigationActivityViewModel>

    override fun getViewComponent(module: TestNavigationActivityModule): ViewComponent<TestNavigationActivity> =
        DaggerTestNavigationActivityInjector_TestNavigationActivityComponent.builder()
            .testNavigationActivityModule(module)
            .build()
}