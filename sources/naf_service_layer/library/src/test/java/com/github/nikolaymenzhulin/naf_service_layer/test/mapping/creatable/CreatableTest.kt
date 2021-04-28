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