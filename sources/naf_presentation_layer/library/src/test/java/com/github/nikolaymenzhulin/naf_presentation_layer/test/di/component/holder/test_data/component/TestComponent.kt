package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.module.TestModule
import dagger.Component

@Component(modules = [TestModule::class])
interface TestComponent : DaggerComponent {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestModule): TestComponent =
            DaggerTestComponent.builder()
                .testModule(module)
                .build()
    }
}