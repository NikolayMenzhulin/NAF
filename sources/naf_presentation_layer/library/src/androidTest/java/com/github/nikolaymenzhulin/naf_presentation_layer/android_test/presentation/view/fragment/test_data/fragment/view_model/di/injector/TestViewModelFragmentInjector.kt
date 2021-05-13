package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.TestViewModelFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.holder.TestViewModelFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module.TestViewModelFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestViewModelFragmentInjector(
    view: TestViewModelFragment,
    module: TestViewModelFragmentModule = TestViewModelFragmentModule()
) : AbstractViewInjector<TestViewModelFragment, TestViewModelFragmentModule>(view, module) {

    override fun initComponent(module: TestViewModelFragmentModule) {
        TestViewModelFragmentComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<TestViewModelFragment> =
        TestViewModelFragmentComponentHolder.component

    override fun clearComponent() {
        TestViewModelFragmentComponentHolder.clearComponent()
    }
}