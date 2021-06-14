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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.bind.TestBindViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.inflate.TestInflateViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_FIRST

class TestViewBindingFragmentRoute(private val screenType: ScreenType) : AbstractFragmentRoute<TestViewBindingFragment>() {

    constructor(args: Bundle?) : this(
        args?.getSerializable(EXTRA_FIRST) as ScreenType
    )

    enum class ScreenType {
        BIND, INFLATE
    }

    override fun getFragment(): TestViewBindingFragment {
        val fragment: TestViewBindingFragment =
            when (screenType) {
                BIND -> TestBindViewBindingFragment()
                INFLATE -> TestInflateViewBindingFragment()
            }
        return fragment.apply {
            val args = Bundle().apply {
                putSerializable(EXTRA_FIRST, screenType)
            }
            arguments = args
        }
    }
}