package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base.BaseFragmentTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ViewModelFragmentTest : BaseFragmentTest(R.navigation.graph_view_model_fragment_test) {

    companion object {

        const val CURRENT_NUMBER_INIT_VALUE = "1"
        const val SAVE_TAG = " (restored)"
    }

    @Test
    @DisplayName("Check observing of data of a view model")
    fun checkObservingViewModelData() {
        onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE)))

        val increasedNumber: String = (CURRENT_NUMBER_INIT_VALUE.toInt() + 1).toString()
        onView(withId(R.id.increase_btn)).perform(click())
        onView(withId(R.id.current_number_tv)).check(matches(withText(increasedNumber)))
    }

    @Test
    @DisplayName("Check saving of a view model state")
    fun checkSavingViewModelState() {
        activity.scenario.recreate()
        onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE + SAVE_TAG)))
    }
}