/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivity
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class ViewModelActivityTest {

    companion object {

        const val CURRENT_NUMBER_INIT_VALUE = "1"
        const val SAVE_TAG = " (restored)"
    }

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestViewModelActivity> = ActivityScenarioExtension.launch()

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