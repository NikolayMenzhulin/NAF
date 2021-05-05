package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.databinding.ActivityFragmentHostTestBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R

class TestFragmentHostActivity :
    AbstractActivity<TestFragmentHostActivityViewModel, ActivityFragmentHostTestBinding, TestFragmentHostActivityNavigator>(
        ActivityFragmentHostTestBinding::class.java
    ) {

    override val vm: TestFragmentHostActivityViewModel by viewModels()

    override val injector = TestFragmentHostActivityInjector(this)

    override fun onObserveViewModelData() {
        // Do nothing.
    }

    inline fun <reified F> getCurrentFragment(): F? =
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            ?.childFragmentManager?.fragments?.firstOrNull()) as? F
}