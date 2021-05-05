package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity

import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.TestNavigationActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.fragment.TestNavigationActivityFragmentB
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class NavigationActivityTest {

    companion object {

        const val NAVIGATION_RESULT_STRING = "Navigation result."
    }

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestNavigationActivity> = ActivityScenarioExtension.launch()

    @Test
    @DisplayName("Check creating of a navigator")
    fun checkCreatingNavigator() {
        onView(withId(R.id.go_to_fragment_b_btn)).perform(click())
        activity.scenario.onActivity { activity ->
            val navHostFragment: NavHostFragment? =
                activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            assertNotNull(navHostFragment)

            val fragmentB: TestNavigationActivityFragmentB? =
                navHostFragment!!.childFragmentManager.fragments.firstOrNull() as? TestNavigationActivityFragmentB
            assertNotNull(fragmentB)
            assertTrue(fragmentB!!.isVisible)
        }
    }

    @Test
    @DisplayName("Check setting of a result into navigator")
    fun checkSettingResultIntoNavigator() {

        fun TestNavigationActivity.getNavigationResult(): String =
            findViewById<TextView>(R.id.navigation_result_tv).text.toString()

        onView(withId(R.id.go_to_fragment_b_btn)).perform(click())
        pressBack()

        val expectedNavigationResult = NAVIGATION_RESULT_STRING
        var actualNavigationResult = ""
        activity.scenario.onActivity { actualNavigationResult = it.getNavigationResult() }
        assertEquals(expectedNavigationResult, actualNavigationResult)
    }

    @Test
    @DisplayName("Check destroying of a navigator")
    fun checkDestroyingNavigator() {

        fun TestNavigationActivity.getNavigatorHash(): String =
            findViewById<TextView>(R.id.navigator_hash_tv).text.toString()

        with(activity.scenario) {
            var firstNavigatorHash = ""
            onActivity { firstNavigatorHash = it.getNavigatorHash() }

            recreate()

            var secondNavigatorHash = ""
            onActivity { secondNavigatorHash = it.getNavigatorHash() }

            assertNotEquals(firstNavigatorHash, secondNavigatorHash)
        }
    }
}