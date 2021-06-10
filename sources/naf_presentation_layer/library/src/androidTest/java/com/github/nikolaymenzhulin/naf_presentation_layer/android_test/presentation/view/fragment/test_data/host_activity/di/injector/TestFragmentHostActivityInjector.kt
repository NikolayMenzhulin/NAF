package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.TestFragmentHostActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestFragmentHostActivityInjector(
    private val view: TestFragmentHostActivity
) : AbstractViewInjector<TestFragmentHostActivity>(view) {

    override fun initComponent() {
        TestFragmentHostActivityComponentHolder.initComponent(TestFragmentHostActivityModule(view))
    }

    override fun getViewComponent(): ViewComponent<TestFragmentHostActivity> =
        TestFragmentHostActivityComponentHolder.component

    override fun clearComponent() {
        TestFragmentHostActivityComponentHolder.clearComponent()
    }
}