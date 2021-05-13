package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.component.TestViewBindingFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.module.TestViewBindingFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestViewBindingFragmentComponentHolder :
    AbstractComponentHolder<TestViewBindingFragmentComponent, TestViewBindingFragmentModule>() {

    override fun getComponentImpl(module: TestViewBindingFragmentModule): TestViewBindingFragmentComponent =
        TestViewBindingFragmentComponent.create(module)
}