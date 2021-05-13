package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.component.TestViewModelFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module.TestViewModelFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestViewModelFragmentComponentHolder :
    AbstractComponentHolder<TestViewModelFragmentComponent, TestViewModelFragmentModule>() {

    override fun getComponentImpl(module: TestViewModelFragmentModule): TestViewModelFragmentComponent =
        TestViewModelFragmentComponent.create(module)
}