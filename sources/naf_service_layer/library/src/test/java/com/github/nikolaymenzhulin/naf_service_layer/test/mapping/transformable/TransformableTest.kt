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