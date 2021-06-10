package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.component.deps_provider.TestDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.module.TestModule
import dagger.Component

@Component(modules = [TestModule::class])
interface TestComponent : DaggerComponent, TestDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestModule): TestComponent =
            DaggerTestComponent.builder()
                .testModule(module)
                .build()
    }
}