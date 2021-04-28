package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.DependentTransformableUserRM
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.SimpleTransformableUserRM
import retrofit2.http.GET

interface UserApi {

    @GET("/")
    fun getUser(): FlowResponse<SimpleTransformableUserRM>

    @GET("/")
    fun getUserWithDependencies(): FlowResponse<DependentTransformableUserRM>

    @GET("/")
    fun getUsers(): FlowResponse<List<SimpleTransformableUserRM>>

    @GET("/")
    fun getUsersWithDependencies(): FlowResponse<List<DependentTransformableUserRM>>
}