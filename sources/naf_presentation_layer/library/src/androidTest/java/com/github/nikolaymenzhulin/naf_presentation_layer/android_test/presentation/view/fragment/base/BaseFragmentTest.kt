package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base

import androidx.annotation.NavigationRes
import androidx.navigation.Navigation
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.RegisterExtension

abstract class BaseFragmentTest(@NavigationRes private val navGraphId: Int) {

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestFragmentHostActivity> = ActivityScenarioExtension.launch()

    @BeforeEach
    fun setUp() {
        activity.scenario.onActivity { activity ->
            val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
            navController.setGraph(navGraphId)
        }
    }

    protected inline fun <reified F> getTestFragment(): F {
        var fragment: F? = null
        activity.scenario.onActivity { activity ->
            fragment = activity.getCurrentFragment<F>()
        }
        return fragment!!
    }
}