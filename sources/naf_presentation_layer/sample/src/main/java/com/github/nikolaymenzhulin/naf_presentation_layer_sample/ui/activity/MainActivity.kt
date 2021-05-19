package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.ActivityMainBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.injector.MainActivityInjector

/**
 * The single activity of the application.
 */
class MainActivity : AbstractActivity<MainActivityViewModel, ActivityMainBinding, MainActivityNavigator>(
    ActivityMainBinding::class.java
) {

    override val vm: MainActivityViewModel by viewModels()

    override val injector = MainActivityInjector(this)

    override fun onObserveViewModelData() {
        // Do nothing.
    }
}