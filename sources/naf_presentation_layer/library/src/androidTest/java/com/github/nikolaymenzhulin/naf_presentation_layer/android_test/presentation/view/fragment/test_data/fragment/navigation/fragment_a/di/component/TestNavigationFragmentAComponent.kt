package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.TestNavigationFragmentA
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.component.deps_provider.TestNavigationFragmentADepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.di.module.TestNavigationFragmentAModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Component

@PerFragment
@Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestNavigationFragmentAModule::class])
interface TestNavigationFragmentAComponent : ViewComponent<TestNavigationFragmentA>, TestNavigationFragmentADepsProvider {

    companion object {

        fun create(module: TestNavigationFragmentAModule): TestNavigationFragmentAComponent =
            DaggerTestNavigationFragmentAComponent.builder()
                .testFragmentHostActivityComponent(TestFragmentHostActivityComponentHolder.component)
                .testNavigationFragmentAModule(module)
                .build()
    }
}