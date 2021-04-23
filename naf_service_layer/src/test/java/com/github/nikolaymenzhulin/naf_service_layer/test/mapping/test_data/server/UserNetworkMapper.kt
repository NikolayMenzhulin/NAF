package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper.NetworkMapper
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.DependentTransformableUserRM
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.UserDM
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.UserWithDependenciesDM

class UserNetworkMapper(
    private val api: UserApi,
    private val dependency: DependentTransformableUserRM.Dependencies,
) : NetworkMapper {

    fun getUser(): FlowResponse<UserDM> =
        api.getUser().mapToDomain()

    fun getUserWithDependencies(): FlowResponse<UserWithDependenciesDM> =
        api.getUserWithDependencies().mapToDomain(dependency)

    fun getUsers(): FlowResponse<List<UserDM>> =
        api.getUsers().mapListToDomain()

    fun getUsersWithDependencies(): FlowResponse<List<UserWithDependenciesDM>> =
        api.getUsersWithDependencies().mapListToDomain(dependency)
}