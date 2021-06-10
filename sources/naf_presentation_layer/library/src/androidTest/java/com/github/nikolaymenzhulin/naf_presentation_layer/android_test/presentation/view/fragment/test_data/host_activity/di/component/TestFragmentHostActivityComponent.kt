package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.deps_provider.TestFragmentHostActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.TestFragmentHostActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppDepsProvider::class], modules = [TestFragmentHostActivityModule::class])
interface TestFragmentHostActivityComponent : ViewComponent<TestFragmentHostActivity>, TestFragmentHostActivityDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestFragmentHostActivityModule): TestFragmentHostActivityComponent =
            DaggerTestFragmentHostActivityComponent.builder()
                .appDepsProvider(AppComponentHolder.component)
                .testFragmentHostActivityModule(module)
                .build()
    }
}