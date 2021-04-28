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