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
package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.component.deps_provider.TestDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.module.TestModule
import dagger.Component

@Component(modules = [TestModule::class])
interface TestComponent : DaggerComponent, TestDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: TestModule): TestComponent =
            DaggerTestComponent.builder()
                .testModule(module)
                .build()
    }
}