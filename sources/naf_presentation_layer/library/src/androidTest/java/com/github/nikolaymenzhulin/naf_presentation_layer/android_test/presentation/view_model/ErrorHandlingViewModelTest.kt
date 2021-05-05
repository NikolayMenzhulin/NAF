package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestErrorHandlingActivity
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class ErrorHandlingViewModelTest {

    companion object {

        val EXPECTED_EXCEPTION = Exception()
    }

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestErrorHandlingActivity> = ActivityScenarioExtension.launch()

    @Test
    @DisplayName("Check error handling inside a view model")
    fun checkErrorHandlingInsideViewModel() {
        onView(withId(R.id.create_error_flow_response_btn)).perform(click())
        onView(withId(R.id.exception_class_name_tv)).check(matches(withText(EXPECTED_EXCEPTION::class.simpleName)))
    }
}