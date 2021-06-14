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