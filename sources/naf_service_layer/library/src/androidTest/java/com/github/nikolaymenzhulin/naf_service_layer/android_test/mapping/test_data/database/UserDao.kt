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

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserSM
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserWithDependenciesSM
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUsers(users: List<UserSM>)

    @Insert
    suspend fun insertUsersWithDependencies(users: List<UserWithDependenciesSM>)

    @Query("SELECT * FROM usersm WHERE name = :name")
    suspend fun getUser(name: String): UserSM

    @Query("SELECT * FROM userwithdependenciessm WHERE name = :name")
    suspend fun getUserWithDependencies(name: String): UserWithDependenciesSM

    @Query("SELECT * FROM usersm WHERE name = :name")
    suspend fun getUsers(name: String): List<UserSM>

    @Query("SELECT * FROM userwithdependenciessm WHERE name = :name")
    suspend fun getUsersWithDependencies(name: String): List<UserWithDependenciesSM>

    @Query("SELECT * FROM usersm WHERE name = :name")
    fun getUserFlow(name: String): Flow<UserSM>

    @Query("SELECT * FROM userwithdependenciessm WHERE name = :name")
    fun getUserWithDependenciesFlow(name: String): Flow<UserWithDependenciesSM>

    @Query("SELECT * FROM usersm WHERE name = :name")
    fun getUsersFlow(name: String): Flow<List<UserSM>>

    @Query("SELECT * FROM userwithdependenciessm WHERE name = :name")
    fun getUsersWithDependenciesFlow(name: String): Flow<List<UserWithDependenciesSM>>
}