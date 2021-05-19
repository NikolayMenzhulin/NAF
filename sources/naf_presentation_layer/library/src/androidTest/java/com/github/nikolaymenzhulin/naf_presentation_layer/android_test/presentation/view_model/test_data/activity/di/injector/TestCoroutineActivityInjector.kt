package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestCoroutineActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.holder.TestCoroutineActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.TestCoroutineActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestCoroutineActivityInjector(
    private val view: TestCoroutineActivity
) : AbstractViewInjector<TestCoroutineActivity>(view) {

    override fun initComponent() {
        TestCoroutineActivityComponentHolder.initComponent(TestCoroutineActivityModule(view))
    }

    override fun getViewComponent(): ViewComponent<TestCoroutineActivity> =
        TestCoroutineActivityComponentHolder.component

    override fun clearComponent() {
        TestCoroutineActivityComponentHolder.clearComponent()
    }
}