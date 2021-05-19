package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.holder.TestInjectableFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.module.TestInjectableFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestInjectableFragmentInjector(
    view: TestInjectableFragment,
    module: TestInjectableFragmentModule = TestInjectableFragmentModule()
) : AbstractViewInjector<TestInjectableFragment, TestInjectableFragmentModule>(view, module) {

    override fun initComponent(module: TestInjectableFragmentModule) {
        TestInjectableFragmentComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestInjectableFragment> =
        TestInjectableFragmentComponentHolder.component

    override fun clearComponent() {
        TestInjectableFragmentComponentHolder.clearComponent()
    }
}