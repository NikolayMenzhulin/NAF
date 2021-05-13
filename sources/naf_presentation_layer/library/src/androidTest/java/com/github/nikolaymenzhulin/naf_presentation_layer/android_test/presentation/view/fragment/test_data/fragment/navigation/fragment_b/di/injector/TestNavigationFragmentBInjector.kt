package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.TestNavigationFragmentB
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.holder.TestNavigationFragmentBComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.module.TestNavigationFragmentBModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestNavigationFragmentBInjector(
    view: TestNavigationFragmentB,
    module: TestNavigationFragmentBModule = TestNavigationFragmentBModule(view)
) : AbstractViewInjector<TestNavigationFragmentB, TestNavigationFragmentBModule>(view, module) {

    override fun initComponent(module: TestNavigationFragmentBModule) {
        TestNavigationFragmentBComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestNavigationFragmentB> =
        TestNavigationFragmentBComponentHolder.component

    override fun clearComponent() {
        TestNavigationFragmentBComponentHolder.clearComponent()
    }
}