package com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain

import java.io.Serializable

class UserDM private constructor(
    val name: String,
    val surname: String,
    val age: Int
) {

    override fun toString(): String = "$name $surname, $age years old"

    class Builder(
        var name: String? = null,
        var surname: String? = null,
        var age: Int? = null
    ) : Serializable {

        fun build(): UserDM =
            UserDM(
                name = name ?: throw IllegalStateException("Empty user name"),
                surname = surname ?: throw IllegalStateException("Empty user surname"),
                age = age ?: throw IllegalStateException("Empty user age")
            )
    }
}