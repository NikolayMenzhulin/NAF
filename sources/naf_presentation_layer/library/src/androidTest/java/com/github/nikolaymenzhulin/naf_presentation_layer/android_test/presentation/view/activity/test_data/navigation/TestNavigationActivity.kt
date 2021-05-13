package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation

import android.os.Bundle
import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.injector.TestNavigationActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.ActivityNavigationTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.NavigationActivity

class TestNavigationActivity :
    NavigationActivity<TestNavigationActivityViewModel, ActivityNavigationTestBinding, TestNavigationActivityNavigator>(
        contentLayoutId = R.layout.activity_navigation_test,
        vbClass = ActivityNavigationTestBinding::class.java
    ) {

    override val vm: TestNavigationActivityViewModel by viewModels()

    override val injector = TestNavigationActivityInjector(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigatorHash()
        onObserveViewModelData()
    }

    override fun onObserveViewModelData() {
        vm.navigationResult.observe(this) { vb.navigationResultTv.text = it }
        vm.navigatorHash.observe(this) { vb.navigatorHashTv.text = it }
    }

    fun goToFragmentB() {
        navigator.goToFragmentB()
    }

    private fun initNavigatorHash() {
        vm.setNavigatorHash(navigator.hashCode().toString())
    }
}