package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.inflate

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.injector.TestViewBindingActivityInjector

class TestInflateViewBindingActivity : TestViewBindingActivity(
    contentLayoutId = R.layout.activity_view_binding_test
) {

    override val injector = TestViewBindingActivityInjector(this)
}