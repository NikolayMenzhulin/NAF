package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment

import android.widget.TextView
import androidx.annotation.IdRes
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.bind.TestBindViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.inflate.TestInflateViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class ViewBindingFragmentTest {

    companion object {

        const val CURRENT_NUMBER_INIT_VALUE = "1"
    }

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestFragmentHostActivity> = ActivityScenarioExtension.launch()

    @Test
    @DisplayName("Check creating of a view binding by a bind method")
    fun checkCreatingViewBindingByBind() {
        setNavGraph(startDestinationId = R.id.test_bind_view_binding_fragment)
        onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE)))
    }

    @Test
    @DisplayName("Check creating of a view binding by a inflate method")
    fun checkCreatingViewBindingByInflate() {
        setNavGraph(startDestinationId = R.id.test_inflate_view_binding_fragment)
        onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE)))
    }

    @Test
    @DisplayName("Check destroying of a view binding created by a bind method")
    fun checkDestroyingViewBindingCreatedByBind() {
        setNavGraph(startDestinationId = R.id.test_bind_view_binding_fragment)
        checkDestroyingViewBinding<TestBindViewBindingFragment>()
    }

    @Test
    @DisplayName("Check destroying of a view binding created by a inflate method")
    fun checkDestroyingViewBindingCreatedByInflate() {
        setNavGraph(startDestinationId = R.id.test_inflate_view_binding_fragment)
        checkDestroyingViewBinding<TestInflateViewBindingFragment>()
    }

    private inline fun <reified V : TestViewBindingFragment> checkDestroyingViewBinding() {
        var fragment: V = getTestFragment()
        val firstViewBindingHash: String =
            fragment.requireView().findViewById<TextView>(R.id.view_binding_hash_tv).text.toString()

        activity.scenario.recreate()

        fragment = getTestFragment()
        val secondViewBindingHash: String =
            fragment.requireView().findViewById<TextView>(R.id.view_binding_hash_tv).text.toString()

        assertNotEquals(firstViewBindingHash, secondViewBindingHash)
    }

    private fun setNavGraph(@IdRes startDestinationId: Int) {
        activity.scenario.onActivity { activity ->
            val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
            val navGraph = navController.navInflater.inflate(R.navigation.graph_view_binding_fragment_test)
            navGraph.startDestination = startDestinationId
            navController.graph = navGraph
        }
    }

    private inline fun <reified F> getTestFragment(): F {
        var fragment: F? = null
        activity.scenario.onActivity { activity ->
            fragment = activity.getCurrentFragment<F>()
        }
        return fragment!!
    }
}