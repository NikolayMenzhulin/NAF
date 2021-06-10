package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestCoroutineActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.component.deps_provider.TestCoroutineActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.module.TestCoroutineActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [TestCoroutineActivityModule::class])
interface TestCoroutineActivityComponent : ViewComponent<TestCoroutineActivity>, TestCoroutineActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestCoroutineActivityModule): TestCoroutineActivityComponent =
            DaggerTestCoroutineActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .testCoroutineActivityModule(module)
                .build()
    }
}