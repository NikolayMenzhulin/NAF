package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base.BaseFragmentTest
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_a.TestNavigationFragmentA
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.TestNavigationFragmentB
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NavigationFragmentTest : BaseFragmentTest(R.navigation.graph_navigation_fragment_test) {

    companion object {

        const val NAVIGATION_RESULT_STRING = "Navigation result."
    }

    @Test
    @DisplayName("Check creating of a navigator")
    fun checkCreatingNavigator() {
        onView(withId(R.id.go_to_fragment_b_btn)).perform(click())
        val fragmentB: TestNavigationFragmentB = getTestFragment()
        assertTrue(fragmentB.isVisible)
    }

    @Test
    @DisplayName("Check setting of a result into navigator")
    fun checkSettingResultIntoNavigator() {

        fun TestNavigationFragmentA.getNavigationResult(): String =
            requireView().findViewById<TextView>(R.id.navigation_result_tv).text.toString()

        onView(withId(R.id.go_to_fragment_b_btn)).perform(click())
        pressBack()

        val fragmentA: TestNavigationFragmentA = getTestFragment()
        val expectedNavigationResult: String = NAVIGATION_RESULT_STRING
        val actualNavigationResult: String = fragmentA.getNavigationResult()
        assertEquals(expectedNavigationResult, actualNavigationResult)
    }

    @Test
    @DisplayName("Check destroying of a navigator")
    fun checkDestroyingNavigator() {

        fun TestNavigationFragmentA.getNavigatorHash(): String =
            requireView().findViewById<TextView>(R.id.navigator_hash_tv).text.toString()

        var fragmentA: TestNavigationFragmentA = getTestFragment()
        val firstNavigatorHash: String = fragmentA.getNavigatorHash()

        activity.scenario.recreate()

        fragmentA = getTestFragment()
        val secondNavigatorHash: String = fragmentA.getNavigatorHash()

        assertNotEquals(firstNavigatorHash, secondNavigatorHash)
    }
}