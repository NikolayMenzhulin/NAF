package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.component.TestViewModelActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.module.TestViewModelActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestViewModelActivityComponentHolder :
    AbstractComponentHolder<TestViewModelActivityComponent, TestViewModelActivityModule>() {

    override fun getComponentImpl(module: TestViewModelActivityModule): TestViewModelActivityComponent =
        TestViewModelActivityComponent.create(module)
}