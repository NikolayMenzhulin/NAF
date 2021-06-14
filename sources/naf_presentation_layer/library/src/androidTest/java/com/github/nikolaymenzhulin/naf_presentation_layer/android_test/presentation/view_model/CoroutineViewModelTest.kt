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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model

import android.widget.TextView
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view_model.test_data.activity.TestCoroutineActivity
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class CoroutineViewModelTest {

    companion object {

        val EXPECTED_EXCEPTION = Exception()
    }

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestCoroutineActivity> = ActivityScenarioExtension.launch()

    @Test
    @DisplayName("Check error handling inside FlowResponse")
    fun checkErrorHandlingInsideFlowResponse() {
        onView(withId(R.id.create_error_flow_response_btn)).perform(click())
        onView(withId(R.id.exception_class_name_tv)).check(matches(withText(EXPECTED_EXCEPTION::class.simpleName)))
    }

    @Test
    @DisplayName("Check launch coroutine reuse")
    fun checkLaunchCoroutineReuse() {
        checkCoroutineReuse(
            startCoroutineBtnResId = R.id.start_coroutine_by_launch_btn,
            coroutineJobHashTvResId = R.id.launch_coroutine_job_hash_tv
        )
    }

    @Test
    @DisplayName("Check async coroutine reuse")
    fun checkAsyncCoroutineReuse() {
        checkCoroutineReuse(
            startCoroutineBtnResId = R.id.start_coroutine_by_async_btn,
            coroutineJobHashTvResId = R.id.async_coroutine_job_hash_tv
        )
    }

    @Test
    @DisplayName("Check launchIn coroutine reuse")
    fun checkLaunchInCoroutineReuse() {
        checkCoroutineReuse(
            startCoroutineBtnResId = R.id.start_coroutine_by_launch_in_btn,
            coroutineJobHashTvResId = R.id.launch_in_coroutine_job_hash_tv
        )
    }

    private fun checkCoroutineReuse(@IdRes startCoroutineBtnResId: Int, @IdRes coroutineJobHashTvResId: Int) {

        fun getStartedCoroutineHash(): String? {
            onView(withId(startCoroutineBtnResId)).perform(click())
            var jobHash: String? = null
            activity.scenario.onActivity { activity ->
                jobHash = activity.findViewById<TextView>(coroutineJobHashTvResId).text.toString()
            }
            return jobHash
        }

        val firstJobHash: String? = getStartedCoroutineHash()
        val secondJobHash: String? = getStartedCoroutineHash()

        assertNotNull(firstJobHash)
        assertNotNull(secondJobHash)
        assertEquals(firstJobHash, secondJobHash)
    }
}