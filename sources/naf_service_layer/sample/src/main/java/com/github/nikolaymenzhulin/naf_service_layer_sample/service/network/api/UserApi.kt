package com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.api

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.model.request.UserReqM
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.model.response.UserResM
import retrofit2.http.Body
import retrofit2.http.PUT

interface UserApi {

    @PUT("/")
    fun putUser(@Body body: UserReqM): FlowResponse<UserResM>
}