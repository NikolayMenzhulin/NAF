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

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.bind.TestBindViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.inflate.TestInflateViewBindingActivity
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ViewBindingActivityTest {

    companion object {

        const val CURRENT_NUMBER_INIT_VALUE = "1"
    }

    @Test
    @DisplayName("Check creating of a view binding by a bind method")
    fun checkCreatingViewBindingByBind() {
        checkCreatingViewBinding<TestBindViewBindingActivity>()
    }

    @Test
    @DisplayName("Check creating of a view binding by a inflate method")
    fun checkCreatingViewBindingByInflate() {
        checkCreatingViewBinding<TestInflateViewBindingActivity>()
    }

    @Test
    @DisplayName("Check destroying of a view binding created by a bind method")
    fun checkDestroyingViewBindingCreatedByBind() {
        checkDestroyingViewBinding<TestBindViewBindingActivity>()
    }

    @Test
    @DisplayName("Check destroying of a view binding created by a inflate method")
    fun checkDestroyingViewBindingCreatedByInflate() {
        checkDestroyingViewBinding<TestInflateViewBindingActivity>()
    }

    private inline fun <reified V : TestViewBindingActivity> checkCreatingViewBinding() {
        ActivityScenario.launch(V::class.java)
            .apply {
                onView(withId(R.id.current_number_tv)).check(matches(withText(CURRENT_NUMBER_INIT_VALUE)))
            }.also { activity ->
                activity.close()
            }
    }

    private inline fun <reified V : TestViewBindingActivity> checkDestroyingViewBinding() {
        ActivityScenario.launch(V::class.java)
            .apply {
                var firstViewBindingHash = ""
                onActivity { firstViewBindingHash = it.findViewById<TextView>(R.id.view_binding_hash_tv).text.toString() }

                recreate()

                var secondViewBindingHash = ""
                onActivity { secondViewBindingHash = it.findViewById<TextView>(R.id.view_binding_hash_tv).text.toString() }

                assertNotEquals(firstViewBindingHash, secondViewBindingHash)
            }.also { activity ->
                activity.close()
            }
    }
}