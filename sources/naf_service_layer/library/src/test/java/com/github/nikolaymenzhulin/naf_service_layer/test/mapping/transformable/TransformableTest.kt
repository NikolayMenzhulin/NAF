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
package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.transformable

import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TransformableTest {

    @Test
    fun `Check SimpleTransformable mapping`() {
        val simpleTransformableUser = SimpleTransformableUserRM()

        val expectedUser = UserDM()
        val actualUser = simpleTransformableUser.transform()

        assertEquals(expectedUser, actualUser)
    }

    @Test
    fun `Check DependentTransformable mapping`() {
        val dependentTransformableUser = DependentTransformableUserRM()
        val dependencies = DependentTransformableUserRM.Dependencies(USER_MOBILE_PHONE, USER_WORK_PHONE)

        val expectedUser = UserWithDependenciesDM()
        val actualUser = dependentTransformableUser.transform(dependency = dependencies)

        assertEquals(expectedUser, actualUser)
    }
}