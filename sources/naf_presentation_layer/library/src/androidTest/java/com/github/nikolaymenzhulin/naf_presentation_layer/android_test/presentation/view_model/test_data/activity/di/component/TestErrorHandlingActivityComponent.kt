package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestErrorHandlingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.component.deps_provider.TestErrorHandlingActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.TestErrorHandlingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(modules = [TestErrorHandlingActivityModule::class])
interface TestErrorHandlingActivityComponent : ViewComponent<TestErrorHandlingActivity>, TestErrorHandlingActivityDepsProvider {

    companion object {

        fun create(module: TestErrorHandlingActivityModule): TestErrorHandlingActivityComponent =
            DaggerTestErrorHandlingActivityComponent.builder()
                .testErrorHandlingActivityModule(module)
                .build()
    }
}