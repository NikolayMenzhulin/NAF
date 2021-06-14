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
package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.holder.TestComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.module.TestModule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ComponentHolderTest {

    @AfterEach
    fun tearDown() {
        TestComponentHolder.clearComponent()
    }

    @Test
    fun `Check initialization of a component inside a holder`() {
        TestComponentHolder.initComponent(TestModule())
        assertNotNull(TestComponentHolder.component)
    }

    @Test
    fun `Check clearing of a component inside a holder`() {
        TestComponentHolder.apply {
            initComponent(TestModule())
            clearComponent()
        }
        assertThrows<IllegalStateException> { TestComponentHolder.component }
    }
}