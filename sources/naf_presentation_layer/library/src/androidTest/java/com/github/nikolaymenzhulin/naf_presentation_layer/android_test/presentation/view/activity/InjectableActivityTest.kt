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

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.TestInjectableActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.holder.TestInjectableActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.RegisterExtension

class InjectableActivityTest {

    companion object {

        const val DEPENDENCY_STRING = "Test dependency."
    }

    @JvmField
    @RegisterExtension
    val activity: ActivityScenarioExtension<TestInjectableActivity> = ActivityScenarioExtension.launch()

    @Test
    @DisplayName("Check creating of a view component")
    fun checkCreatingViewComponent() {
        activity.scenario.onActivity {
            val viewComponent: DaggerComponent = TestInjectableActivityComponentHolder.component
            assertNotNull(viewComponent)
        }
    }

    @Test
    @DisplayName("Check resolving of view dependencies")
    fun checkResolvingViewDeps() {
        activity.scenario.onActivity { activity ->
            val expectedDependency: String = DEPENDENCY_STRING
            val actualDependency: String = activity.dependency
            assertEquals(expectedDependency, actualDependency)
        }
    }

    @Test
    @DisplayName("Check destroying of a view component")
    fun checkDestroyingViewComponent() {
        activity.scenario.close()
        assertThrows<IllegalStateException> {
            TestInjectableActivityComponentHolder.component
        }
    }
}