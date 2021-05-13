package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.component.TestNavigationFragmentAComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.module.TestNavigationFragmentAModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestNavigationFragmentAComponentHolder :
    AbstractComponentHolder<TestNavigationFragmentAComponent, TestNavigationFragmentAModule>() {

    override fun getComponentImpl(module: TestNavigationFragmentAModule): TestNavigationFragmentAComponent =
        TestNavigationFragmentAComponent.create(module)
}