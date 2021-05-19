package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.component.TestNavigationActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.module.TestNavigationActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder

object TestNavigationActivityComponentHolder :
    AbstractComponentHolder<TestNavigationActivityComponent, TestNavigationActivityModule>() {

    override fun getComponentImpl(module: TestNavigationActivityModule): TestNavigationActivityComponent =
        TestNavigationActivityComponent.create(module)
}