package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.mapper

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.adapter.FlowResponseCallAdapterFactory
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.*
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server.UserApi
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server.UserNetworkMapper
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server.enqueueResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NetworkMapperTest {

    private companion object {

        const val SUCCESSFUL_USER_RESPONSE_JSON = """{"name":"$USER_NAME","surname":"$USER_SURNAME"}"""
        const val SUCCESSFUL_USERS_RESPONSE_JSON =
            """[
                {"name":"$USER_NAME","surname":"$USER_SURNAME"},
                {"name":"$USER_NAME","surname":"$USER_SURNAME"},
                {"name":"$USER_NAME","surname":"$USER_SURNAME"}
               ]"""
        const val ERROR_RESPONSE_JSON = """{"error":"Some server error message"}"""
    }

    private lateinit var server: MockWebServer
    private lateinit var userMapper: UserNetworkMapper

    private val dependencies = DependentTransformableUserRM.Dependencies(USER_MOBILE_PHONE, USER_WORK_PHONE)
    private val expectedUser = UserDM()
    private val expectedUserWithDependencies = UserWithDependenciesDM()

    @BeforeEach
    fun setUp() {
        server = MockWebServer()

        val retrofit: Retrofit =
            Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addCallAdapterFactory(FlowResponseCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val userApi: UserApi = retrofit.create()
        userMapper = UserNetworkMapper(api = userApi, dependency = dependencies)
    }

    @AfterEach
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `Check mapping of data when a response code is 200 and the result is User`() {
        checkMappingWhenSuccess(
            responseBody = SUCCESSFUL_USER_RESPONSE_JSON,
            expectedResponseData = expectedUser
        ) { userMapper.getUser() }
    }

    @Test
    fun `Check mapping of data when a response code is 500 and the result is User`() {
        checkMappingWhenError(userMapper::getUser)
    }

    @Test
    fun `Check mapping of data when a response code is 200 and the result is UserWithDependencies`() {
        checkMappingWhenSuccess(
            responseBody = SUCCESSFUL_USER_RESPONSE_JSON,
            expectedResponseData = expectedUserWithDependencies
        ) { userMapper.getUserWithDependencies() }
    }

    @Test
    fun `Check mapping of data when a response code is 500 and the result is UserWithDependencies`() {
        checkMappingWhenError(userMapper::getUserWithDependencies)
    }

    @Test
    fun `Check mapping of data when a response code is 200 and the result is a list of Users`() {
        val expectedUsers = listOf(expectedUser, expectedUser, expectedUser)
        checkMappingWhenSuccess(
            responseBody = SUCCESSFUL_USERS_RESPONSE_JSON,
            expectedResponseData = expectedUsers
        ) { userMapper.getUsers() }
    }

    @Test
    fun `Check mapping of data when a response code is 500 and the result is a list of Users`() {
        checkMappingWhenError(userMapper::getUsers)
    }

    @Test
    fun `Check mapping of data when a response code is 200 and the result is a list of UsersWithDependencies`() {
        val expectedUsersWithDependencies = listOf(
            expectedUserWithDependencies,
            expectedUserWithDependencies,
            expectedUserWithDependencies
        )
        checkMappingWhenSuccess(
            responseBody = SUCCESSFUL_USERS_RESPONSE_JSON,
            expectedResponseData = expectedUsersWithDependencies
        ) { userMapper.getUsersWithDependencies() }
    }

    @Test
    fun `Check mapping of data when a response code is 500 and the result is a list of UsersWithDependencies`() {
        checkMappingWhenError(userMapper::getUsersWithDependencies)
    }

    private fun <T> checkMappingWhenSuccess(
        responseBody: String,
        expectedResponseData: T,
        responseCreator: () -> FlowResponse<T>,
    ) {
        server.enqueueResponse(responseCode = 200, responseBody = responseBody)

        val responseStates = responseCreator().getResponseStates()
        assertTrue { responseStates[0].isLoading }
        assertTrue { responseStates[1].isSuccess }

        val actualResponseData = responseStates[1].getData()
        assertEquals(expectedResponseData, actualResponseData)
    }

    private fun <T> checkMappingWhenError(responseCreator: () -> FlowResponse<T>) {
        server.enqueueResponse(responseCode = 500, responseBody = ERROR_RESPONSE_JSON)

        val responseStates = responseCreator().getResponseStates()
        assertTrue { responseStates[0].isLoading }
        assertTrue { responseStates[1].isError }
        assertTrue { responseStates[1].getError() is HttpException }
    }

    private fun <T> FlowResponse<T>.getResponseStates(): List<Response<T>> {
        val responseStates: MutableList<Response<T>> = mutableListOf()
        runBlocking { collect(responseStates::add) }
        return responseStates
    }
}