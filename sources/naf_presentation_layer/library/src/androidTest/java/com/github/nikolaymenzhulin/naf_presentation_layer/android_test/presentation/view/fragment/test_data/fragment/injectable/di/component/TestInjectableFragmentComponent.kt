/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.component.deps_provider.TestInjectableFragmentDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.module.TestInjectableFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.component.deps_provider.TestFragmentHostActivityDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Component

@PerFragment
@Component(dependencies = [TestFragmentHostActivityDepsProvider::class], modules = [TestInjectableFragmentModule::class])
interface TestInjectableFragmentComponent : ViewComponent<TestInjectableFragment>, TestInjectableFragmentDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestInjectableFragmentModule): TestInjectableFragmentComponent =
            DaggerTestInjectableFragmentComponent.builder()
                .testFragmentHostActivityDepsProvider(TestFragmentHostActivityComponentHolder.component)
                .testInjectableFragmentModule(module)
                .build()
    }
}