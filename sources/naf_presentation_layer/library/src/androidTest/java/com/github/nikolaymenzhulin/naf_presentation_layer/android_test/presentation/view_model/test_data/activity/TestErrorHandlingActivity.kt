package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.di.injector.TestErrorHandlingActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.ViewModelActivity

class TestErrorHandlingActivity : ViewModelActivity<TestErrorHandlingActivityViewModel>(R.layout.activity_error_handling_test) {

    override val vm: TestErrorHandlingActivityViewModel by viewModels()

    override val injector = TestErrorHandlingActivityInjector(this)

    private lateinit var exceptionClassNameTv: TextView
    private lateinit var createErrorFlowResponseBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initListeners()
    }

    override fun onObserveViewModelData() {
        // Do nothing.
    }

    fun printErrorClassName(error: Throwable) {
        exceptionClassNameTv.text = error::class.simpleName
    }

    private fun initViews() {
        exceptionClassNameTv = findViewById(R.id.exception_class_name_tv)
        createErrorFlowResponseBtn = findViewById(R.id.create_error_flow_response_btn)
    }

    private fun initListeners() {
        createErrorFlowResponseBtn.setOnClickListener { vm.emitErrorFlowResponse() }
    }
}