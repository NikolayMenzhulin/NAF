package com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.mapper

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper.NetworkMapper
import com.github.nikolaymenzhulin.naf_service_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.api.UserApi
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.model.request.UserReqM
import com.github.nikolaymenzhulin.naf_service_layer_sample.utils.MockServer
import retrofit2.create

class UserNetworkMapper : NetworkMapper {

    private val userApi: UserApi by lazy { MockServer.retrofit.create() }

    fun putUser(userName: String): FlowResponse<UserDM> =
        userApi.putUser(body = UserReqM.create(userName)).mapToDomain()
}