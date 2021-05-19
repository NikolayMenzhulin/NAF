package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.component.TestCoroutineActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.TestCoroutineActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder

object TestCoroutineActivityComponentHolder :
    AbstractComponentHolder<TestCoroutineActivityComponent, TestCoroutineActivityModule>() {

    override fun getComponentImpl(module: TestCoroutineActivityModule): TestCoroutineActivityComponent =
        TestCoroutineActivityComponent.create(module)
}