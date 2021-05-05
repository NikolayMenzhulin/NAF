package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.TestNavigationActivity

class TestNavigationActivityFragmentA : Fragment(R.layout.fragment_navigation_activity_a_test) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.go_to_fragment_b_btn).setOnClickListener {
            (requireActivity() as TestNavigationActivity).goToFragmentB()
        }
    }
}