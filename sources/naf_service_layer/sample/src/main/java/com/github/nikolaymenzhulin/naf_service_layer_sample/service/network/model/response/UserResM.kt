package com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.model.response

import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import com.github.nikolaymenzhulin.naf_service_layer_sample.domain.UserDM
import com.google.gson.annotations.SerializedName

data class UserResM(
    @SerializedName("name") private val name: String
) : SimpleTransformable<UserDM> {

    override fun transform(): UserDM = UserDM(name = name)
}