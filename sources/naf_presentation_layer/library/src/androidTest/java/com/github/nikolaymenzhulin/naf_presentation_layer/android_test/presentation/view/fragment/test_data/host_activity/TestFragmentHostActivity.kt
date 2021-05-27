package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.injector.TestFragmentHostActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.ActivityFragmentHostTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.terrakok.cicerone.androidx.AppNavigator

class TestFragmentHostActivity :
    AbstractActivity<TestFragmentHostActivityViewModel, ActivityFragmentHostTestBinding, AppNavigator>(
        ActivityFragmentHostTestBinding::class.java
    ) {

    override val vm: TestFragmentHostActivityViewModel by viewModels()

    override val injector = TestFragmentHostActivityInjector(this)

    override fun createNavigator() = AppNavigator(this, R.id.fragment_container)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }

    fun <R : AbstractFragmentRoute<*>> openFragmentScreen(route: R) {
        vm.openFragmentScreen(route)
    }

    fun <F : Fragment> openFragmentScreen(fragment: F) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}