package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.component.deps_provider.TestInjectableFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.module.TestInjectableFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Component

@PerFragment
@Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestInjectableFragmentModule::class])
interface TestInjectableFragmentComponent : ViewComponent<TestInjectableFragment>, TestInjectableFragmentDepsProvider {

    companion object {

        fun create(module: TestInjectableFragmentModule): TestInjectableFragmentComponent =
            DaggerTestInjectableFragmentComponent.builder()
                .testFragmentHostActivityComponent(TestFragmentHostActivityComponentHolder.component)
                .testInjectableFragmentModule(module)
                .build()
    }
}