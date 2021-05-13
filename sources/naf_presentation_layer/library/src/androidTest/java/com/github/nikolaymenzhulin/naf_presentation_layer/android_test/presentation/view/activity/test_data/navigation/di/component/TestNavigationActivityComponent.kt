package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.TestNavigationActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.component.deps_provider.TestNavigationActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.module.TestNavigationActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(modules = [TestNavigationActivityModule::class])
interface TestNavigationActivityComponent : ViewComponent<TestNavigationActivity>, TestNavigationActivityDepsProvider {

    companion object {

        fun create(module: TestNavigationActivityModule): TestNavigationActivityComponent =
            DaggerTestNavigationActivityComponent.builder()
                .testNavigationActivityModule(module)
                .build()
    }
}