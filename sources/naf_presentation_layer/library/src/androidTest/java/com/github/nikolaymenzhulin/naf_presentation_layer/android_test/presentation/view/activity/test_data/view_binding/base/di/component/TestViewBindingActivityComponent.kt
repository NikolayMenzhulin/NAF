package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.component.deps_provider.TestViewBindingActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.module.TestViewBindingActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [TestViewBindingActivityModule::class])
interface TestViewBindingActivityComponent : ViewComponent<TestViewBindingActivity>, TestViewBindingActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestViewBindingActivityModule): TestViewBindingActivityComponent =
            DaggerTestViewBindingActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .testViewBindingActivityModule(module)
                .build()
    }
}