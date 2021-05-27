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