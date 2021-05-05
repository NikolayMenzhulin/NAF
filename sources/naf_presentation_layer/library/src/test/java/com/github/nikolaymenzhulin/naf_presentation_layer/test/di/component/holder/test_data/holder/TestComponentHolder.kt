package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.component.TestComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.module.TestModule

object TestComponentHolder : AbstractComponentHolder<TestComponent, TestModule>() {

    override fun getComponentImpl(module: TestModule): TestComponent = TestComponent.create(module)
}