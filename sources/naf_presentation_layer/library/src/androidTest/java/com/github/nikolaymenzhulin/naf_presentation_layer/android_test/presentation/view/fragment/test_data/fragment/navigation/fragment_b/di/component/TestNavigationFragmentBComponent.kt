package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.TestNavigationFragmentB
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.component.deps_provider.TestNavigationFragmentBDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.module.TestNavigationFragmentBModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Component

@PerFragment
@Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestNavigationFragmentBModule::class])
interface TestNavigationFragmentBComponent : ViewComponent<TestNavigationFragmentB>, TestNavigationFragmentBDepsProvider {

    companion object {

        fun create(module: TestNavigationFragmentBModule): TestNavigationFragmentBComponent =
            DaggerTestNavigationFragmentBComponent.builder()
                .testFragmentHostActivityComponent(TestFragmentHostActivityComponentHolder.component)
                .testNavigationFragmentBModule(module)
                .build()
    }
}