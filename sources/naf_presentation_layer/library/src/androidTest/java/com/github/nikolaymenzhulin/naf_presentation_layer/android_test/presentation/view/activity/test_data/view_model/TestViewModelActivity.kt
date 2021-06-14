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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.injector.TestViewModelActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelActivity

class TestViewModelActivity : ViewModelActivity<TestViewModelActivityViewModel>(R.layout.activity_view_model_test) {

    override val vm: TestViewModelActivityViewModel by viewModels()

    override val injector = TestViewModelActivityInjector(this)

    private lateinit var currentNumberTv: TextView
    private lateinit var increaseBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListeners()
        observeViewModel()
    }

    private fun initViews() {
        currentNumberTv = findViewById(R.id.current_number_tv)
        increaseBtn = findViewById(R.id.increase_btn)
    }

    private fun initListeners() {
        increaseBtn.setOnClickListener { vm.increaseCurrentNumber() }
    }

    private fun observeViewModel() {
        vm.currentNumber.observe(this) { currentNumber ->
            currentNumberTv.text = currentNumber
        }
    }
}