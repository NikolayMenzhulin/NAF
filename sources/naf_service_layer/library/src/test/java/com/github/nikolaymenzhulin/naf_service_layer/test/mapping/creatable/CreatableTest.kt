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
package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.creatable

import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreatableTest {

    @Test
    fun `Check SimpleCreatable mapping`() {
        val expectedUser = SimpleCreatableUserRM()
        val actualUser = SimpleCreatableUserRM.create(from = UserDM())
        assertEquals(expectedUser, actualUser)
    }

    @Test
    fun `Check DependentCreatable mapping`() {
        val dependencies = DependentCreatableUserRM.Dependencies(USER_MOBILE_PHONE, USER_WORK_PHONE)
        val expectedUser = DependentCreatableUserRM()
        val actualUser = DependentCreatableUserRM.create(from = UserDM(), dependency = dependencies)
        assertEquals(expectedUser, actualUser)
    }
}