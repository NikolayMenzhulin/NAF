# NAF Service Layer

The NAF component that provides base entities for implementing a service layer in your app. It includes interfaces for response/request/storage models that standardizing their mapping to the domain model and interfaces with basic methods for mapping when working with a network or data storage (database, cache, etc.). This component is intended to be used in conjunction with the library [Flow-Response-Retrofit-Adapter](https://github.com/NikolayMenzhulin/Flow-Response-Retrofit-Adapter).

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nikolaymenzhulin/naf_service_layer/badge.svg?)](https://maven-badges.herokuapp.com/maven-central/com.github.nikolaymenzhulin/naf_service_layer) [![License](https://img.shields.io/badge/license-Apache%202.0-dark.svg)](http://www.apache.org/licenses/LICENSE-2.0)

## How to use it?

The logic of working with the component is based on two principles:

1. The mapping logic must be encapsulated inside the response/request/storage models.
2. Mapping should be initiated inside a mapper class that implements the `NetworkMapper` or `StorageMapper` interface.

### Mapping response models:

Suppose we have the response model `UserResponse` and the domain model `UserDomain`.
Mapping `UserResponse` to `UserDomain` must be encapsulated inside `UserResponse`.
To do this, it is enough to extend `UserResponse` from the [SimpleTransformable](https://github.com/NikolayMenzhulin/NAF/blob/main/sources/naf_service_layer/library/src/main/java/com/github/nikolaymenzhulin/naf_service_layer/mapping/transformable/Transformable.kt) interface and implement the `transform` method, which will contain the mapping logic.

***Sample:***

```kotlin
data class UserDomain(val name: String)

data class UserResponse(
    @SerializedName("name") private val name: String
) : SimpleTransformable<UserDomain> {

    override fun transform(): UserDomain = UserDomain(name)
}
```

If some external dependencies are needed to map `UserResponse` to `UserDomain`, you should represent these dependencies as a wrapper object and to extend `UserResponse` from the [DependentTransformable](https://github.com/NikolayMenzhulin/NAF/blob/main/sources/naf_service_layer/library/src/main/java/com/github/nikolaymenzhulin/naf_service_layer/mapping/transformable/Transformable.kt) interface.
Then the `transform` method will contain this object as a parameter and it will be possible to carry out mapping using its dependencies.


***Sample:***

```kotlin
data class UserDomain(val name: String, val phone: String, val email: String)

data class UserResponse(
    @SerializedName("name") private val name: String
) : DependentTransformable<UserDomain, UserResponse.Dependencies> {

    data class Dependencies(val phone: String, val email: String)

    override fun transform(dependency: Dependencies): UserDomain =
        with(dependency) { UserDomain(name, phone, email) }
}
```

### Mapping request models:

Suppose we have the response model `UserRequest` and the domain model `UserDomain`.
Mapping `UserRequest` to `UserDomain` must be encapsulated inside `UserRequest`.
To do this, it is enough to add a companion object inside `UserRequest`, which must be extended from the [SimpleCreatable](https://github.com/NikolayMenzhulin/NAF/blob/main/sources/naf_service_layer/library/src/main/java/com/github/nikolaymenzhulin/naf_service_layer/mapping/creatable/Creatable.kt) interface and implement the `create` method, which will contain the mapping logic.

***Sample:***

```kotlin
data class UserDomain(val name: String)

data class UserRequest(
    @SerializedName("name") private val name: String
) {

    companion object : SimpleCreatable<UserDomain, UserRequest> {

        override fun create(from: UserDomain): UserRequest =
            with(from) { UserRequest(name) }
    }
}
```

If some external dependencies are needed to map `UserRequest` to `UserDomain`, you should represent these dependencies as a wrapper object and to extend the `UserRequest` companion from the [DependentCreatable](https://github.com/NikolayMenzhulin/NAF/blob/main/sources/naf_service_layer/library/src/main/java/com/github/nikolaymenzhulin/naf_service_layer/mapping/creatable/Creatable.kt) interface.
Then the `create` method will contain this object as a parameter and it will be possible to carry out mapping using its dependencies.

***Sample:***

```kotlin
data class UserDomain(val name: String)

data class UserRequest(
    @SerializedName("name") private val name: String,
    @SerializedName("phone") private val phone: String,
    @SerializedName("email") private val email: String
) {

    data class Dependencies(val phone: String, val email: String)

    companion object : DependentCreatable<UserDomain, UserRequest, UserRequest.Dependencies> {

        override fun create(from: UserDomain, dependency: Dependencies): UserRequest =
            with(from) { UserRequest(name, dependency.phone, dependency.email) }
    }
}
```

### Mapping storage models:

Storage models are mapped according to the same principles as described above for response and request models.
The only addition is that storage models can simultaneously implement both `Transformable` and ` Creatable` interfaces.

### Working with mappers:

Mapping must initiate a mapper class that implements the `Network Mapper` or `StorageMapper` interface.  
In the case of networking, this class should be located somewhere between the Api and the Repository.
And in the case of working with data stores, this class should be located somewhere between the data source (DAO/cache/...) and the Repository.

***Sample of NetworkMapper implementation:***

```kotlin
interface UsersApi {

    @GET("/user")
    fun getUser(): FlowResponse<UserResponse>

    @GET("/users")
    fun getUsers(): FlowResponse<List<UserResponse>>
}

class UsersMapper(private val api: UsersApi) : NetworkMapper {

    fun getUser(): FlowResponse<UserDomain> = api.getUser().mapToDomain()

    fun getUsers(): FlowResponse<List<UserDomain>> = api.getUsers().mapListToDomain()
}

class UsersRepository(private val mapper: UsersMapper) {

    fun getUser(): FlowResponse<UserDomain> = mapper.getUser()

    fun getUsers(): FlowResponse<List<UserDomain>> = mapper.getUsers()
}
```

A complete list of available mapping methods can be found in the [NetworkMapper](https://github.com/NikolayMenzhulin/NAF/blob/main/sources/naf_service_layer/library/src/main/java/com/github/nikolaymenzhulin/naf_service_layer/mapping/mapper/NetworkMapper.kt) and [StorageMapper](https://github.com/NikolayMenzhulin/NAF/blob/main/sources/naf_service_layer/library/src/main/java/com/github/nikolaymenzhulin/naf_service_layer/mapping/mapper/StorageMapper.kt) interfaces.  
In the samples above, the libraries [GSON](https://github.com/google/gson) and [Retrofit](https://github.com/square/retrofit) were used.  
There is also a [sample app](https://github.com/NikolayMenzhulin/NAF/tree/main/sources/naf_service_layer/sample) that demonstrates all of the above.

## Download

**Step 1.** Add the Maven Central repository to your build file:
```groovy
allprojects {
    repositories {
        mavenCentral()
    }
}
```

**Step 2.** Add the dependency:
```groovy
dependencies {
    implementation 'com.github.nikolaymenzhulin:naf_service_layer:1.0.0'
}
```

## License

```
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
```
