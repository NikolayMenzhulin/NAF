package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.FragmentNavigationBTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.NavigationFragment

class TestNavigationFragmentB :
    NavigationFragment<TestNavigationFragmentBViewModel, FragmentNavigationBTestBinding, TestNavigationFragmentBNavigator>(
        contentLayoutId = R.layout.fragment_navigation_b_test,
        vbClass = FragmentNavigationBTestBinding::class.java
    ) {

    override val vm: TestNavigationFragmentBViewModel by viewModels()

    override val injector = TestNavigationFragmentBInjector(this)

    override fun onObserveViewModelData() {
        // Do nothing.
    }
}