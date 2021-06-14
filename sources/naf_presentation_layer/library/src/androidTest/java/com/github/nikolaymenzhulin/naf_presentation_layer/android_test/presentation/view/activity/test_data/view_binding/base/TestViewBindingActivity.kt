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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.ViewBindingActivityTest.Companion.CURRENT_NUMBER_INIT_VALUE
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.ActivityViewBindingTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingActivity

abstract class TestViewBindingActivity(
    @LayoutRes contentLayoutId: Int = 0
) : ViewBindingActivity<TestViewBindingActivityViewModel, ActivityViewBindingTestBinding>(
    contentLayoutId,
    ActivityViewBindingTestBinding::class.java
) {

    override val vm: TestViewBindingActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb.currentNumberTv.root.text = CURRENT_NUMBER_INIT_VALUE
        vb.viewBindingHashTv.text = vb.hashCode().toString()
    }
}