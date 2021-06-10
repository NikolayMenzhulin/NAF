package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.component.TestViewBindingActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.module.TestViewBindingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder

object TestViewBindingActivityComponentHolder :
    AbstractComponentHolder<TestViewBindingActivityComponent, TestViewBindingActivityModule>() {

    override fun getComponentImpl(module: TestViewBindingActivityModule): TestViewBindingActivityComponent =
        TestViewBindingActivityComponent.create(module)
}