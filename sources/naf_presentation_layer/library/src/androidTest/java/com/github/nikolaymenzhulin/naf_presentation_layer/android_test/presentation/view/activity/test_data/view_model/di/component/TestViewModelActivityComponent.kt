package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.component.deps_provider.TestViewModelActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.module.TestViewModelActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(modules = [TestViewModelActivityModule::class])
interface TestViewModelActivityComponent : ViewComponent<TestViewModelActivity>, TestViewModelActivityDepsProvider {

    companion object {

        fun create(module: TestViewModelActivityModule): TestViewModelActivityComponent =
            DaggerTestViewModelActivityComponent.builder()
                .testViewModelActivityModule(module)
                .build()
    }
}