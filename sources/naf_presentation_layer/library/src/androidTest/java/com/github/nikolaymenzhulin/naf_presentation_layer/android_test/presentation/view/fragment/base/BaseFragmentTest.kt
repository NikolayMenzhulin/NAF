package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.extension.RegisterExtension

abstract class BaseFragmentTest {

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestFragmentHostActivity> = ActivityScenarioExtension.launch()

    protected inline fun <reified F> getTestFragment(): F {
        var fragment: F? = null
        activity.scenario.onActivity { activity ->
            fragment = activity.supportFragmentManager.fragments.first() as F
        }
        return fragment!!
    }
}