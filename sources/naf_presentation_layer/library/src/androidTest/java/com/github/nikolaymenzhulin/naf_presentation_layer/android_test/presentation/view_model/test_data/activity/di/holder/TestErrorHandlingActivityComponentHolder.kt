package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.component.TestErrorHandlingActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.TestErrorHandlingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestErrorHandlingActivityComponentHolder :
    AbstractComponentHolder<TestErrorHandlingActivityComponent, TestErrorHandlingActivityModule>() {

    override fun getComponentImpl(module: TestErrorHandlingActivityModule): TestErrorHandlingActivityComponent =
        TestErrorHandlingActivityComponent.create(module)
}