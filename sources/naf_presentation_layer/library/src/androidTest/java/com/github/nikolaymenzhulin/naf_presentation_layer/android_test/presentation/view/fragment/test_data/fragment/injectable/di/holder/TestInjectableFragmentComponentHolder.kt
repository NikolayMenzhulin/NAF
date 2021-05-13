package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.component.TestInjectableFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.module.TestInjectableFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestInjectableFragmentComponentHolder :
    AbstractComponentHolder<TestInjectableFragmentComponent, TestInjectableFragmentModule>() {

    override fun getComponentImpl(module: TestInjectableFragmentModule): TestInjectableFragmentComponent =
        TestInjectableFragmentComponent.create(module)
}