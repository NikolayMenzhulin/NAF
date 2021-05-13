package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.TestViewModelFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.component.deps_provider.TestViewModelFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module.TestViewModelFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.TestFragmentHostActivityComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Component

@PerFragment
@Component(dependencies = [TestFragmentHostActivityComponent::class], modules = [TestViewModelFragmentModule::class])
interface TestViewModelFragmentComponent : ViewComponent<TestViewModelFragment>, TestViewModelFragmentDepsProvider {

    companion object {

        fun create(module: TestViewModelFragmentModule): TestViewModelFragmentComponent =
            DaggerTestViewModelFragmentComponent.builder()
                .testFragmentHostActivityComponent(TestFragmentHostActivityComponentHolder.component)
                .testViewModelFragmentModule(module)
                .build()
    }
}