package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.TestFragmentHostActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestFragmentHostActivityInjector(
    view: TestFragmentHostActivity,
    module: TestFragmentHostActivityModule = TestFragmentHostActivityModule(view)
) : AbstractViewInjector<TestFragmentHostActivity, TestFragmentHostActivityModule>(view, module) {

    override fun initComponent(module: TestFragmentHostActivityModule) {
        TestFragmentHostActivityComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestFragmentHostActivity> =
        TestFragmentHostActivityComponentHolder.component

    override fun clearComponent() {
        TestFragmentHostActivityComponentHolder.clearComponent()
    }
}