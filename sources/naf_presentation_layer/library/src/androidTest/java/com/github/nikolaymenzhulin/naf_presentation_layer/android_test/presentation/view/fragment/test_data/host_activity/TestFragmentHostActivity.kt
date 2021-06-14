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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.injector.TestFragmentHostActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.ActivityFragmentHostTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator.ScreenNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

class TestFragmentHostActivity :
    AbstractActivity<TestFragmentHostActivityViewModel, ActivityFragmentHostTestBinding, ScreenNavigator>(
        ActivityFragmentHostTestBinding::class.java
    ) {

    override val vm: TestFragmentHostActivityViewModel by viewModels()

    override val injector = TestFragmentHostActivityInjector(this)

    override fun createNavigator() = ScreenNavigator(this, R.id.fragment_container)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }

    fun <R : AbstractFragmentRoute<*>> openFragmentScreen(route: R) {
        vm.openFragmentScreen(route)
    }

    fun <F : Fragment> openFragmentScreen(fragment: F) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}