package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestErrorHandlingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.holder.TestErrorHandlingActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.TestErrorHandlingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestErrorHandlingActivityInjector(
    view: TestErrorHandlingActivity,
    module: TestErrorHandlingActivityModule = TestErrorHandlingActivityModule(view)
) : AbstractViewInjector<TestErrorHandlingActivity, TestErrorHandlingActivityModule>(view, module) {

    override fun initComponent(module: TestErrorHandlingActivityModule) {
        TestErrorHandlingActivityComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestErrorHandlingActivity> =
        TestErrorHandlingActivityComponentHolder.component

    override fun clearComponent() {
        TestErrorHandlingActivityComponentHolder.clearComponent()
    }
}