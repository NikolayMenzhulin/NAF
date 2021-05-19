package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.component.deps_provider.TestViewModelActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.module.TestViewModelActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [TestViewModelActivityModule::class])
interface TestViewModelActivityComponent : ViewComponent<TestViewModelActivity>, TestViewModelActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestViewModelActivityModule): TestViewModelActivityComponent =
            DaggerTestViewModelActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .testViewModelActivityModule(module)
                .build()
    }
}