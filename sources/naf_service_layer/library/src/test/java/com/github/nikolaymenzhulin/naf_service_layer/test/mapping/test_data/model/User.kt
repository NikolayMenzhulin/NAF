package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model

import com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable.DependentCreatable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable.SimpleCreatable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.DependentTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.DependentTransformableUserRM.Dependencies

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

data class SimpleTransformableUserRM(
    val name: String = USER_NAME,
    val surname: String = USER_SURNAME,
) : SimpleTransformable<UserDM> {

    override fun transform(): UserDM = UserDM(name, surname)
}

data class DependentTransformableUserRM(
    val name: String = USER_NAME,
    val surname: String = USER_SURNAME,
) : DependentTransformable<UserWithDependenciesDM, Dependencies> {

    data class Dependencies(val mobilePhone: String, val workPhone: String)

    override fun transform(dependency: Dependencies): UserWithDependenciesDM =
        with(dependency) {
            UserWithDependenciesDM(name, surname, mobilePhone, workPhone)
        }
}

data class SimpleCreatableUserRM(
    val name: String = USER_NAME,
    val surname: String = USER_SURNAME,
) {

    companion object : SimpleCreatable<UserDM, SimpleCreatableUserRM> {

        override fun create(from: UserDM): SimpleCreatableUserRM =
            with(from) {
                SimpleCreatableUserRM(name, surname)
            }
    }
}

data class DependentCreatableUserRM(
    val name: String = USER_NAME,
    val surname: String = USER_SURNAME,
    val mobilePhone: String = USER_MOBILE_PHONE,
    val workPhone: String = USER_WORK_PHONE,
) {

    data class Dependencies(val mobilePhone: String, val workPhone: String)

    companion object : DependentCreatable<UserDM, DependentCreatableUserRM, Dependencies> {

        override fun create(from: UserDM, dependency: Dependencies): DependentCreatableUserRM =
            DependentCreatableUserRM(
                name = from.name,
                surname = from.surname,
                mobilePhone = dependency.mobilePhone,
                workPhone = dependency.workPhone
            )
    }
}