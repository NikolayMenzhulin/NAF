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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.injector.TestViewModelFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelFragment

class TestViewModelFragment : ViewModelFragment<TestViewModelFragmentViewModel>() {

    override val vm: TestViewModelFragmentViewModel by viewModels()

    override val injector = TestViewModelFragmentInjector(this)

    private lateinit var currentNumberTv: TextView
    private lateinit var increaseBtn: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_view_model_test, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initListeners()
        observeViewModel()
    }

    private fun initViews(view: View) {
        currentNumberTv = view.findViewById(R.id.current_number_tv)
        increaseBtn = view.findViewById(R.id.increase_btn)
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