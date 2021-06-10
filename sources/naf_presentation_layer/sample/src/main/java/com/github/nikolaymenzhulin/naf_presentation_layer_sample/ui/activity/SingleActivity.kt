package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator.ScreenNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.ActivitySingleBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.injector.SingleActivityInjector

/**
 * The single activity of the application.
 */
class SingleActivity : AbstractActivity<SingleActivityViewModel, ActivitySingleBinding, ScreenNavigator>(
    ActivitySingleBinding::class.java
) {

    override val vm: SingleActivityViewModel by viewModels()

    override val injector = SingleActivityInjector(this)

    override fun createNavigator() = ScreenNavigator(this, R.id.fragment_container)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }
}