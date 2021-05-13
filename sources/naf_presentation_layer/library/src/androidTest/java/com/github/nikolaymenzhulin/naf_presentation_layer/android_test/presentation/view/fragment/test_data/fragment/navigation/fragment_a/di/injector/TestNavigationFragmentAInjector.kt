package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.TestNavigationFragmentA
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.holder.TestNavigationFragmentAComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.module.TestNavigationFragmentAModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestNavigationFragmentAInjector(
    view: TestNavigationFragmentA,
    module: TestNavigationFragmentAModule = TestNavigationFragmentAModule(view)
) : AbstractViewInjector<TestNavigationFragmentA, TestNavigationFragmentAModule>(view, module) {

    override fun initComponent(module: TestNavigationFragmentAModule) {
        TestNavigationFragmentAComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestNavigationFragmentA> =
        TestNavigationFragmentAComponentHolder.component

    override fun clearComponent() {
        TestNavigationFragmentAComponentHolder.clearComponent()
    }
}