package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.component.TestNavigationFragmentBComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.module.TestNavigationFragmentBModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestNavigationFragmentBComponentHolder :
    AbstractComponentHolder<TestNavigationFragmentBComponent, TestNavigationFragmentBModule>() {

    override fun getComponentImpl(module: TestNavigationFragmentBModule): TestNavigationFragmentBComponent =
        TestNavigationFragmentBComponent.create(module)
}