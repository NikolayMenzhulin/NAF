package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.holder.TestViewBindingFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.module.TestViewBindingFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestViewBindingFragmentInjector(
    private val view: TestViewBindingFragment
) : AbstractViewInjector<TestViewBindingFragment>(view) {

    override fun initComponent() {
        TestViewBindingFragmentComponentHolder.initComponent(TestViewBindingFragmentModule(view))
    }

    override fun getViewComponent(): ViewComponent<TestViewBindingFragment> =
        TestViewBindingFragmentComponentHolder.component

    override fun clearComponent() {
        TestViewBindingFragmentComponentHolder.clearComponent()
    }
}