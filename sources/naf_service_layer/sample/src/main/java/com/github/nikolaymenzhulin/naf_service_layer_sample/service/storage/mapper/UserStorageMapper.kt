package com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.mapper

import com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper.StorageMapper
import com.github.nikolaymenzhulin.naf_service_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.model.UserSM
import com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.storage.UserStorage

class UserStorageMapper(cacheDirPath: String) : StorageMapper {

    val storage: UserStorage = UserStorage(cacheDirPath)

    fun putUser(user: UserDM) {
        val userSM: UserSM = UserSM.create(user)
        storage.put(key = user.name, data = userSM)
    }

    fun getUsers(): List<UserDM> = storage.getAll().mapListToDomain()
}