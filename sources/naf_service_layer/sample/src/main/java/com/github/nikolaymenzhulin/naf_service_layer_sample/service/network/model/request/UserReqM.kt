package com.github.nikolaymenzhulin.naf_service_layer_sample.service.network.model.request

import com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable.SimpleCreatable
import com.google.gson.annotations.SerializedName

@Suppress("UNUSED")
class UserReqM private constructor(
    @SerializedName("name") private val name: String
) {

    companion object : SimpleCreatable<String, UserReqM> {

        override fun create(from: String): UserReqM = UserReqM(name = from)
    }
}