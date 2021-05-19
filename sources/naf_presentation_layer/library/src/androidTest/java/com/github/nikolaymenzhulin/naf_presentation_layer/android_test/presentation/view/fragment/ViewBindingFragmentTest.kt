package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base.BaseFragmentTest
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.bind.TestBindViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.inflate.TestInflateViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ViewBindingFragmentTest : BaseFragmentTest() {

    companion object {

        const val CURRENT_NUMBER_INIT_VALUE = "1"
    }

    @Test
    @DisplayName("Check creating of a view binding by a bind method")
    fun checkCreatingViewBindingByBind() {
        openViewBindingFragment(BIND)
        onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE)))
    }

    @Test
    @DisplayName("Check creating of a view binding by a inflate method")
    fun checkCreatingViewBindingByInflate() {
        openViewBindingFragment(INFLATE)
        onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE)))
    }

    @Test
    @DisplayName("Check destroying of a view binding created by a bind method")
    fun checkDestroyingViewBindingCreatedByBind() {
        openViewBindingFragment(BIND)
        checkDestroyingViewBinding<TestBindViewBindingFragment>()
    }

    @Test
    @DisplayName("Check destroying of a view binding created by a inflate method")
    fun checkDestroyingViewBindingCreatedByInflate() {
        openViewBindingFragment(INFLATE)
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

    private fun openViewBindingFragment(screenType: ScreenType) {
        activity.scenario.onActivity { activity ->
            activity.openFragmentScreen(TestViewBindingFragmentRoute(screenType))
        }
    }
}