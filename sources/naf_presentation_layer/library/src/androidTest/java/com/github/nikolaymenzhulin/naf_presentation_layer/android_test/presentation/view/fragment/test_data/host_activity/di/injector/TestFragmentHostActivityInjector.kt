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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.holder.TestFragmentHostActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.TestFragmentHostActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

class TestFragmentHostActivityInjector(
    private val view: TestFragmentHostActivity
) : AbstractViewInjector<TestFragmentHostActivity>(view) {

    override fun initComponent() {
        TestFragmentHostActivityComponentHolder.initComponent(TestFragmentHostActivityModule(view))
    }

    override fun getViewComponent(): ViewComponent<TestFragmentHostActivity> =
        TestFragmentHostActivityComponentHolder.component

    override fun clearComponent() {
        TestFragmentHostActivityComponentHolder.clearComponent()
    }
}