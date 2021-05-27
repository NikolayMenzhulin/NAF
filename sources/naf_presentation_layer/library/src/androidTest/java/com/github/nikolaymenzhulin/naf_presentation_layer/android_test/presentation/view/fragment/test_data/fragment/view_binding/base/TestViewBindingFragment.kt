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