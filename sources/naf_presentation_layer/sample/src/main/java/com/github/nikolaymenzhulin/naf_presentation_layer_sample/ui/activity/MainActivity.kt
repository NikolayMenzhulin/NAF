package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.ActivityMainBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.injector.MainActivityInjector
import com.github.terrakok.cicerone.androidx.AppNavigator

/**
 * The single activity of the application.
 */
class MainActivity : AbstractActivity<MainActivityViewModel, ActivityMainBinding, AppNavigator>(
    ActivityMainBinding::class.java
) {

    override val vm: MainActivityViewModel by viewModels()

    override val injector = MainActivityInjector(this)

    override fun createNavigator() = AppNavigator(this, R.id.fragment_container)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }
}