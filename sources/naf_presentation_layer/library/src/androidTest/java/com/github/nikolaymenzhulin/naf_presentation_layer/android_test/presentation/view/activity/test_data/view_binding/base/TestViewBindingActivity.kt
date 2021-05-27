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