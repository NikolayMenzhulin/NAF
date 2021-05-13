package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.TestNavigationActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.holder.TestNavigationActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.module.TestNavigationActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestNavigationActivityInjector(
    view: TestNavigationActivity,
    module: TestNavigationActivityModule = TestNavigationActivityModule(view)
) : AbstractViewInjector<TestNavigationActivity, TestNavigationActivityModule>(view, module) {

    override fun initComponent(module: TestNavigationActivityModule) {
        TestNavigationActivityComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestNavigationActivity> =
        TestNavigationActivityComponentHolder.component

    override fun clearComponent() {
        TestNavigationActivityComponentHolder.clearComponent()
    }
}