package com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.nikolaymenzhulin.naf_service_layer.android_test.mapping.test_data.model.UserWithDependenciesSM.Dependencies
import com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable.DependentCreatable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable.SimpleCreatable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.DependentTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable

const val EMPTY_STRING = ""
const val USER_NAME = "User Name"
const val USER_SURNAME = "User Surname"
const val USER_MOBILE_PHONE = "0-000-000-0"
const val USER_WORK_PHONE = "1-234-567-8"

data class UserDM(
    val name: String = USER_NAME,
    val surname: String = USER_SURNAME,
)

data class UserWithDependenciesDM(
    val name: String = USER_NAME,
    val surname: String = USER_SURNAME,
    val mobilePhone: String = USER_MOBILE_PHONE,
    val workPhone: String = USER_WORK_PHONE,
)

@Entity
data class UserSM(
    val name: String,
    val surname: String,
) : SimpleTransformable<UserDM> {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    companion object : SimpleCreatable<UserDM, UserSM> {

        override fun create(from: UserDM): UserSM = with(from) { UserSM(name, surname) }
    }

    override fun transform(): UserDM = UserDM(name, surname)
}

@Entity
data class UserWithDependenciesSM(
    val name: String,
    val surname: String,
    val mobilePhone: String,
    val workPhone: String,
) : DependentTransformable<UserWithDependenciesDM, Dependencies> {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    data class Dependencies(val mobilePhone: String, val workPhone: String)

    companion object : DependentCreatable<UserDM, UserWithDependenciesSM, Dependencies> {

        override fun create(from: UserDM, dependency: Dependencies): UserWithDependenciesSM =
            UserWithDependenciesSM(
                name = from.name,
                surname = from.surname,
                mobilePhone = dependency.mobilePhone,
                workPhone = dependency.workPhone
            )
    }

    override fun transform(dependency: Dependencies): UserWithDependenciesDM =
        with(dependency) {
            UserWithDependenciesDM(name, surname, mobilePhone, workPhone)
        }
}