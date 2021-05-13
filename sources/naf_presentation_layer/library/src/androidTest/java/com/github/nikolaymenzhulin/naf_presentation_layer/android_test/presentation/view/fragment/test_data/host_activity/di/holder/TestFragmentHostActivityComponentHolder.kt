package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.TestFragmentHostActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestFragmentHostActivityComponentHolder :
    AbstractComponentHolder<TestFragmentHostActivityComponent, TestFragmentHostActivityModule>() {

    override fun getComponentImpl(module: TestFragmentHostActivityModule): TestFragmentHostActivityComponent =
        TestFragmentHostActivityComponent.create(module)
}