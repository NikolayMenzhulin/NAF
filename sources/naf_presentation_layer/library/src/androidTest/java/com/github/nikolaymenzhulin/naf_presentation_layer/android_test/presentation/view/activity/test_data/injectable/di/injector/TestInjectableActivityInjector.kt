package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.TestInjectableActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.holder.TestInjectableActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.module.TestInjectableActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestInjectableActivityInjector(
    view: TestInjectableActivity,
    module: TestInjectableActivityModule = TestInjectableActivityModule()
) : AbstractViewInjector<TestInjectableActivity, TestInjectableActivityModule>(view, module) {

    override fun initComponent(module: TestInjectableActivityModule) {
        TestInjectableActivityComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestInjectableActivity> =
        TestInjectableActivityComponentHolder.component

    override fun clearComponent() {
        TestInjectableActivityComponentHolder.clearComponent()
    }
}