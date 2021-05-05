package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.FragmentNavigationATestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.NavigationFragment

class TestNavigationFragmentA :
    NavigationFragment<TestNavigationFragmentAViewModel, FragmentNavigationATestBinding, TestNavigationFragmentANavigator>(
        contentLayoutId = R.layout.fragment_navigation_a_test,
        vbClass = FragmentNavigationATestBinding::class.java
    ) {

    override val vm: TestNavigationFragmentAViewModel by viewModels()

    override val injector = TestNavigationFragmentAInjector(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigatorHash()
        initListeners()
    }

    @Suppress("DEPRECATION")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onObserveViewModelData()
    }

    override fun onObserveViewModelData() {
        vm.navigationResult.observe(this) { vb.navigationResultTv.text = it }
        vm.navigatorHash.observe(this) { vb.navigatorHashTv.text = it }
    }

    private fun initNavigatorHash() {
        vm.setNavigatorHash(navigator.hashCode().toString())
    }

    private fun initListeners() {
        vb.goToFragmentBBtn.setOnClickListener { navigator.goToFragmentB() }
    }
}