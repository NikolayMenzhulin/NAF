package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.holder.TestViewModelActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.module.TestViewModelActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestViewModelActivityInjector(
    private val view: TestViewModelActivity
) : AbstractViewInjector<TestViewModelActivity>(view) {

    override fun initComponent() {
        TestViewModelActivityComponentHolder.initComponent(TestViewModelActivityModule(view))
    }

    override fun getViewComponent(): ViewComponent<TestViewModelActivity> =
        TestViewModelActivityComponentHolder.component

    override fun clearComponent() {
        TestViewModelActivityComponentHolder.clearComponent()
    }
}