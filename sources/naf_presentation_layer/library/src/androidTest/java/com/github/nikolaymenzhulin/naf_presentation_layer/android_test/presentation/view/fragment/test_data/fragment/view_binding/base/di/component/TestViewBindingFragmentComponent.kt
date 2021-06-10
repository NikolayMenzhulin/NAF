package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.component.deps_provider.TestViewBindingFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.di.module.TestViewBindingFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.deps_provider.TestFragmentHostActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Component

@PerFragment
@Component(dependencies = [TestFragmentHostActivityDepsProvider::class], modules = [TestViewBindingFragmentModule::class])
interface TestViewBindingFragmentComponent : ViewComponent<TestViewBindingFragment>, TestViewBindingFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestViewBindingFragmentModule): TestViewBindingFragmentComponent =
            DaggerTestViewBindingFragmentComponent.builder()
                .testFragmentHostActivityDepsProvider(TestFragmentHostActivityComponentHolder.component)
                .testViewBindingFragmentModule(module)
                .build()
    }
}