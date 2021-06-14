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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.component.TestViewModelFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module.TestViewModelFragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder

object TestViewModelFragmentComponentHolder :
    AbstractComponentHolder<TestViewModelFragmentComponent, TestViewModelFragmentModule>() {

    override fun getComponentImpl(module: TestViewModelFragmentModule): TestViewModelFragmentComponent =
        TestViewModelFragmentComponent.create(module)
}