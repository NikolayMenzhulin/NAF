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
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.ViewBindingFragmentTest.Companion.CURRENT_NUMBER_INIT_VALUE
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.FragmentViewBindingTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingFragment

abstract class TestViewBindingFragment(
    @LayoutRes contentLayoutId: Int = 0
) : ViewBindingFragment<TestViewBindingFragmentViewModel, FragmentViewBindingTestBinding>(
    contentLayoutId,
    FragmentViewBindingTestBinding::class.java
) {

    override val vm: TestViewBindingFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb.currentNumberTv.root.text = CURRENT_NUMBER_INIT_VALUE
        vb.viewBindingHashTv.text = vb.hashCode().toString()
    }
}