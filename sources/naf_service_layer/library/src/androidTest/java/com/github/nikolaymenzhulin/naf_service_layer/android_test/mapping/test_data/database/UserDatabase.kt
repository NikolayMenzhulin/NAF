package com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserSM
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserWithDependenciesSM

@Database(entities = [UserSM::class, UserWithDependenciesSM::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}