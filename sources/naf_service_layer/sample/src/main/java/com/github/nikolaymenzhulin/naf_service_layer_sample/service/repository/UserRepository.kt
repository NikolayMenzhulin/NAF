package com.github.nikolaymenzhulin.naf_service_layer_sample.service.repository

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.mapper.UserNetworkMapper
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.mapper.UserStorageMapper
import com.github.nikolaymenzhulin.naf_service_layer_sample.utils.mapResponseData

class UserRepository(
    private val userNetworkMapper: UserNetworkMapper,
    private val userStorageMapper: UserStorageMapper
) {

    fun putUser(userName: String): FlowResponse<Boolean> =
        userNetworkMapper.putUser(userName)
            .mapResponseData { user ->
                val containsUser: Boolean = userStorageMapper.storage.contains(key = user.name)
                if (!containsUser) userStorageMapper.putUser(user)
                containsUser
            }

    fun getUsers(): List<UserDM> = userStorageMapper.getUsers()

    fun hasUsers(): Boolean = !userStorageMapper.storage.isEmpty()

    fun clearUsers(): Unit = userStorageMapper.storage.clear()
}