package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.holder.TestViewBindingActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.module.TestViewBindingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestViewBindingActivityInjector(
    private val view: TestViewBindingActivity
) : AbstractViewInjector<TestViewBindingActivity>(view) {

    override fun initComponent() {
        TestViewBindingActivityComponentHolder.initComponent(TestViewBindingActivityModule(view))
    }

    override fun getViewComponent(): ViewComponent<TestViewBindingActivity> =
        TestViewBindingActivityComponentHolder.component

    override fun clearComponent() {
        TestViewBindingActivityComponentHolder.clearComponent()
    }
}