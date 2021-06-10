package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.TestInjectableActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.component.deps_provider.TestInjectableActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.module.TestInjectableActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [TestInjectableActivityModule::class])
interface TestInjectableActivityComponent : ViewComponent<TestInjectableActivity>, TestInjectableActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestInjectableActivityModule): TestInjectableActivityComponent =
            DaggerTestInjectableActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .testInjectableActivityModule(module)
                .build()
    }
}