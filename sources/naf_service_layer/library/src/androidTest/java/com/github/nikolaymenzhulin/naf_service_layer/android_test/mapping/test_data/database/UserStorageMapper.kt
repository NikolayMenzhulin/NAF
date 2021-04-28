package com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.database

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserDM
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserSM
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserWithDependenciesDM
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserWithDependenciesSM
import com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper.StorageMapper
import kotlinx.coroutines.flow.Flow

class UserStorageMapper(
    private val dao: UserDao,
    private val dependencies: UserWithDependenciesSM.Dependencies,
) : StorageMapper {

    suspend fun insertUsers(users: List<UserDM>) {
        val userEntities = users.map { UserSM.create(from = it) }
        dao.insertUsers(userEntities)
    }

    suspend fun insertUsersWithDependencies(users: List<UserDM>) {
        val userEntities = users.map { UserWithDependenciesSM.create(from = it, dependency = dependencies) }
        dao.insertUsersWithDependencies(userEntities)
    }

    suspend fun getUser(name: String): UserDM? =
        dao.getUser(name).mapToDomain()

    suspend fun getUserWithDependencies(name: String): UserWithDependenciesDM? =
        dao.getUserWithDependencies(name).mapToDomain(dependencies)

    suspend fun getUsers(name: String): List<UserDM> =
        dao.getUsers(name).mapListToDomain()

    suspend fun getUsersWithDependencies(name: String): List<UserWithDependenciesDM> =
        dao.getUsersWithDependencies(name).mapListToDomain(dependencies)

    fun getUserFlow(name: String): Flow<UserDM?> =
        dao.getUserFlow(name).mapToDomain()

    fun getUserWithDependenciesFlow(name: String): Flow<UserWithDependenciesDM?> =
        dao.getUserWithDependenciesFlow(name).mapToDomain(dependencies)

    fun getUsersFlow(name: String): Flow<List<UserDM>> =
        dao.getUsersFlow(name).mapListToDomain()

    fun getUsersWithDependenciesFlow(name: String): Flow<List<UserWithDependenciesDM>> =
        dao.getUsersWithDependenciesFlow(name).mapListToDomain(dependencies)

    fun getUserFlowResponse(name: String): FlowResponse<UserDM> =
        dao.getUserFlow(name).mapToDomainResponse()

    fun getUserWithDependenciesFlowResponse(name: String): FlowResponse<UserWithDependenciesDM> =
        dao.getUserWithDependenciesFlow(name).mapToDomainResponse(dependencies)

    fun getUsersFlowResponse(name: String): FlowResponse<List<UserDM>> =
        dao.getUsersFlow(name).mapListToDomainResponse()

    fun getUsersWithDependenciesFlowResponse(name: String): FlowResponse<List<UserWithDependenciesDM>> =
        dao.getUsersWithDependenciesFlow(name).mapListToDomainResponse(dependencies)
}