package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.component.TestInjectableActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.module.TestInjectableActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder

object TestInjectableActivityComponentHolder :
    AbstractComponentHolder<TestInjectableActivityComponent, TestInjectableActivityModule>() {

    override fun getComponentImpl(module: TestInjectableActivityModule): TestInjectableActivityComponent =
        TestInjectableActivityComponent.create(module)
}