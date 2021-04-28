package com.github.nikolaymenzhulin.naf_service_layer_sample.service.storage.model

import com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable.SimpleCreatable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import com.github.nikolaymenzhulin.naf_service_layer_sample.domain.UserDM

class UserSM private constructor(
    private val name: String
) : SimpleTransformable<UserDM> {

    companion object : SimpleCreatable<UserDM, UserSM> {

        override fun create(from: UserDM): UserSM = UserSM(name = from.name)
    }

    override fun transform(): UserDM = UserDM(name = name)
}