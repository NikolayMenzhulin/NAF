package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.injector.TestViewModelFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelFragment

class TestViewModelFragment : ViewModelFragment<TestViewModelFragmentViewModel>(R.layout.fragment_view_model_test) {

    override val vm: TestViewModelFragmentViewModel by viewModels()

    override val injector = TestViewModelFragmentInjector(this)

    private lateinit var currentNumberTv: TextView
    private lateinit var increaseBtn: Button

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