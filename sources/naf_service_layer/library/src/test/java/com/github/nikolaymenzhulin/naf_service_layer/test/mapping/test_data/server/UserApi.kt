/*
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
*/
package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.DependentTransformableUserRM
import com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.model.SimpleTransformableUserRM
import retrofit2.http.GET

interface UserApi {

    @GET("/")
    fun getUser(): FlowResponse<SimpleTransformableUserRM>

    @GET("/")
    fun getUserWithDependencies(): FlowResponse<DependentTransformableUserRM>

    @GET("/")
    fun getUsers(): FlowResponse<List<SimpleTransformableUserRM>>

    @GET("/")
    fun getUsersWithDependencies(): FlowResponse<List<DependentTransformableUserRM>>
}