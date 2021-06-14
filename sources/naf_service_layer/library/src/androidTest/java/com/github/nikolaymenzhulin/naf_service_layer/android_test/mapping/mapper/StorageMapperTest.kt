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
package com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.mapper

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.database.UserDatabase
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.database.UserStorageMapper
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class StorageMapperTest {

    private lateinit var database: UserDatabase
    private lateinit var userMapper: UserStorageMapper

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    private val dependencies = UserWithDependenciesSM.Dependencies(USER_MOBILE_PHONE, USER_WORK_PHONE)

    private val expectedUser = UserDM()
    private val expectedUsers = listOf(expectedUser, expectedUser, expectedUser)

    private val expectedUserWithDependencies = UserWithDependenciesDM()
    private val expectedUsersWithDependencies = listOf(
        expectedUserWithDependencies,
        expectedUserWithDependencies,
        expectedUserWithDependencies
    )

    @BeforeEach
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
        userMapper = UserStorageMapper(dao = database.getUserDao(), dependencies = dependencies)

        insertUsers()
    }

    @AfterEach
    fun tearDown() {
        database.close()
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is User")
    fun successfulUserResult() {
        checkSuccessfulModelResult(expectedResponseData = expectedUser) {
            userMapper.getUser(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is User")
    fun emptyUserResult() {
        checkEmptyModelResult { userMapper.getUser(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is UserWithDependencies")
    fun successfulUserWithDependenciesResult() {
        checkSuccessfulModelResult(expectedResponseData = expectedUserWithDependencies) {
            userMapper.getUserWithDependencies(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is UserWithDependencies")
    fun emptyUserWithDependenciesResult() {
        checkEmptyModelResult { userMapper.getUserWithDependencies(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a list of Users")
    fun successfulUsersListResult() {
        checkSuccessfulModelResult(expectedResponseData = expectedUsers) {
            userMapper.getUsers(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a list of Users")
    fun emptyUsersListResult() {
        checkEmptyModelResult { userMapper.getUsers(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a list of UsersWithDependencies")
    fun successfulUsersWithDependenciesListResult() {
        checkSuccessfulModelResult(expectedResponseData = expectedUsersWithDependencies) {
            userMapper.getUsersWithDependencies(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a list of UsersWithDependencies")
    fun emptyUsersWithDependenciesListResult() {
        checkEmptyModelResult { userMapper.getUsersWithDependencies(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a flow with User")
    fun successfulFlowUserResult() {
        checkSuccessfulFlowModelResult(expectedResponseData = expectedUser) {
            userMapper.getUserFlow(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a flow with User")
    fun emptyFlowUserResult() {
        checkEmptyFlowModelResult { userMapper.getUserFlow(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a flow with UserWithDependencies")
    fun successfulFlowUserWithDependenciesResult() {
        checkSuccessfulFlowModelResult(expectedResponseData = expectedUserWithDependencies) {
            userMapper.getUserWithDependenciesFlow(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a flow with UserWithDependencies")
    fun emptyFlowUserWithDependenciesResult() {
        checkEmptyFlowModelResult { userMapper.getUserWithDependenciesFlow(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a flow with a list of Users")
    fun successfulFlowUsersListResult() {
        checkSuccessfulFlowModelResult(expectedResponseData = expectedUsers) {
            userMapper.getUsersFlow(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a flow with a list of Users")
    fun emptyFlowUsersListResult() {
        checkEmptyFlowModelResult { userMapper.getUsersFlow(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a flow with a list of UsersWithDependencies")
    fun successfulFlowUsersWithDependenciesListResult() {
        checkSuccessfulFlowModelResult(expectedResponseData = expectedUsersWithDependencies) {
            userMapper.getUsersWithDependenciesFlow(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a flow with a list of UsersWithDependencies")
    fun emptyFlowUsersWithDependenciesListResult() {
        checkEmptyFlowModelResult { userMapper.getUsersWithDependenciesFlow(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a FlowResponse with User")
    fun successfulFlowResponseUserResult() {
        checkSuccessfulFlowResponseModelResult(expectedResponseData = expectedUser) {
            userMapper.getUserFlowResponse(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a FlowResponse with User")
    fun emptyFlowResponseUserResult() {
        checkEmptyFlowResponseModelResult { userMapper.getUserFlowResponse(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a FlowResponse with UserWithDependencies")
    fun successfulFlowResponseUserWithDependenciesResult() {
        checkSuccessfulFlowResponseModelResult(expectedResponseData = expectedUserWithDependencies) {
            userMapper.getUserWithDependenciesFlowResponse(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a FlowResponse with UserWithDependencies")
    fun emptyFlowResponseUserWithDependenciesResult() {
        checkEmptyFlowResponseModelResult { userMapper.getUserWithDependenciesFlowResponse(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a FlowResponse with a list of Users")
    fun successfulFlowResponseUsersListResult() {
        checkSuccessfulFlowResponseModelResult(expectedResponseData = expectedUsers) {
            userMapper.getUsersFlowResponse(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a FlowResponse with a list of Users")
    fun emptyFlowResponseUsersListResult() {
        checkEmptyFlowResponseModelResult { userMapper.getUsersFlowResponse(name = EMPTY_STRING) }
    }

    @Test
    @DisplayName("Check mapping of data when a response is successful and the result is a FlowResponse with a list of UsersWithDependencies")
    fun successfulFlowResponseWithDependenciesListResult() {
        checkSuccessfulFlowResponseModelResult(expectedResponseData = expectedUsersWithDependencies) {
            userMapper.getUsersWithDependenciesFlowResponse(name = USER_NAME)
        }
    }

    @Test
    @DisplayName("Check mapping of data when a response is empty and the result is a FlowResponse with a list of UsersWithDependencies")
    fun emptyFlowResponseWithDependenciesListResult() {
        checkEmptyFlowResponseModelResult { userMapper.getUsersWithDependenciesFlowResponse(name = EMPTY_STRING) }
    }

    private fun insertUsers() {
        runBlocking {
            userMapper.insertUsers(expectedUsers)
            userMapper.insertUsersWithDependencies(expectedUsers)
        }
    }

    private inline fun <reified T> checkSuccessfulModelResult(
        expectedResponseData: T,
        crossinline responseCreator: suspend () -> T?,
    ) {
        val actualResponseData: T? = runBlocking { responseCreator() }
        assertNotNull(actualResponseData)
        if (actualResponseData.isList()) {
            assertTrue { (actualResponseData as List<*>).isNotEmpty() }
        }
        assertEquals(expectedResponseData, actualResponseData)
    }

    private inline fun <reified T> checkEmptyModelResult(crossinline responseCreator: suspend () -> T?) {
        val actualResponseData: T? = runBlocking { responseCreator() }
        if (actualResponseData.isList()) {
            assertTrue { (actualResponseData as List<*>).isEmpty() }
        } else {
            assertNull(actualResponseData)
        }
    }

    private fun <T> checkSuccessfulFlowModelResult(expectedResponseData: T, responseCreator: () -> Flow<T?>) {
        runBlocking {
            responseCreator()
                .take(1)
                .collect { actualResponseData: T? ->
                    assertNotNull(actualResponseData)
                    if (actualResponseData.isList()) {
                        assertTrue { (actualResponseData as List<*>).isNotEmpty() }
                    }
                    assertEquals(expectedResponseData, actualResponseData)
                }
        }
    }

    private fun <T> checkEmptyFlowModelResult(responseCreator: () -> Flow<T?>) {
        runBlocking {
            responseCreator()
                .take(1)
                .collect { actualResponseData: T? ->
                    if (actualResponseData.isList()) {
                        assertTrue { (actualResponseData as List<*>).isEmpty() }
                    } else {
                        assertNull(actualResponseData)
                    }
                }
        }
    }

    private fun <T> checkSuccessfulFlowResponseModelResult(expectedResponseData: T, responseCreator: () -> FlowResponse<T>) {
        val responseStates = responseCreator().getResponseStates()
        assertTrue { responseStates[0].isLoading }
        assertTrue { responseStates[1].isSuccess }

        val actualResponseData = responseStates[1].getData()
        assertEquals(expectedResponseData, actualResponseData)
    }

    private fun <T> checkEmptyFlowResponseModelResult(responseCreator: () -> FlowResponse<T>) {
        val responseStates = responseCreator().getResponseStates()
        assertTrue { responseStates[0].isLoading }
        assertTrue { responseStates[1].isSuccess }
        assertThrows<IllegalStateException> { responseStates[1].getData() }
        assertNull(responseStates[1].getDataOrNull())
    }

    private fun <T> T?.isList(): Boolean = (this as? List<*>) != null

    private fun <T> FlowResponse<T>.getResponseStates(): List<Response<T>> {
        val responseStates: MutableList<Response<T>> = mutableListOf()
        runBlocking { collect(responseStates::add) }
        return responseStates
    }
}