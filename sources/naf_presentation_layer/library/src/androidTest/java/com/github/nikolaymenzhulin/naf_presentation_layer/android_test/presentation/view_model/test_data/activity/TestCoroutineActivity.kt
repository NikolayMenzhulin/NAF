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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.injector.TestCoroutineActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelActivity

class TestCoroutineActivity : ViewModelActivity<TestCoroutineActivityViewModel>(R.layout.activity_coroutine_test) {

    override val vm: TestCoroutineActivityViewModel by viewModels()

    override val injector = TestCoroutineActivityInjector(this)

    private lateinit var exceptionClassNameTv: TextView
    private lateinit var launchCoroutineJobHashTv: TextView
    private lateinit var asyncCoroutineJobHashTv: TextView
    private lateinit var launchInCoroutineJobHashTv: TextView
    private lateinit var createErrorFlowResponseBtn: Button
    private lateinit var startCoroutineByLaunch: Button
    private lateinit var startCoroutineByAsync: Button
    private lateinit var startCoroutineByLaunchIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListeners()
        observeViewModel()
    }

    fun printErrorClassName(error: Throwable) {
        exceptionClassNameTv.text = error::class.simpleName
    }

    private fun initViews() {
        exceptionClassNameTv = findViewById(R.id.exception_class_name_tv)
        launchCoroutineJobHashTv = findViewById(R.id.launch_coroutine_job_hash_tv)
        asyncCoroutineJobHashTv = findViewById(R.id.async_coroutine_job_hash_tv)
        launchInCoroutineJobHashTv = findViewById(R.id.launch_in_coroutine_job_hash_tv)
        createErrorFlowResponseBtn = findViewById(R.id.create_error_flow_response_btn)
        startCoroutineByLaunch = findViewById(R.id.start_coroutine_by_launch_btn)
        startCoroutineByAsync = findViewById(R.id.start_coroutine_by_async_btn)
        startCoroutineByLaunchIn = findViewById(R.id.start_coroutine_by_launch_in_btn)
    }

    private fun initListeners() {
        createErrorFlowResponseBtn.setOnClickListener { vm.emitErrorFlowResponse() }
        startCoroutineByLaunch.setOnClickListener { vm.startCoroutineByLaunch() }
        startCoroutineByAsync.setOnClickListener { vm.startCoroutineByAsync() }
        startCoroutineByLaunchIn.setOnClickListener { vm.startCoroutineByLaunchIn() }
    }

    private fun observeViewModel() {
        vm.launchJob.observe(this) {
            launchCoroutineJobHashTv.text = it.hashCode().toString()
        }
        vm.asyncJob.observe(this) {
            asyncCoroutineJobHashTv.text = it.hashCode().toString()
        }
        vm.launchInJob.observe(this) {
            launchInCoroutineJobHashTv.text = it.hashCode().toString()
        }
    }
}