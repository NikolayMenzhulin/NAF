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
package com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.DependentTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.Transformable
import kotlinx.coroutines.flow.map

/**
 * The base interface for a mapper class that maps models when working with a network.
 */
interface NetworkMapper {

    /**
     * Mapping the response model to the domain model inside the [FlowResponse].
     * Used generics: RM - ResponseModel, DM - DomainModel.
     *
     * @return the [FlowResponse] with the server response,
     * inside which the data inside the [Response.Success] state
     * mapped from the response model to the domain model
     */
    fun <RM : SimpleTransformable<DM>, DM> FlowResponse<RM>.mapToDomain(): FlowResponse<DM> =
        mapInternal { responseModel ->
            responseModel.transform()
        }

    /**
     * Mapping the response model to the domain model inside the [FlowResponse].
     * Used generics: RM - ResponseModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the [FlowResponse] with the server response,
     * inside which the data inside the [Response.Success] state
     * mapped from the response model to the domain model
     */
    fun <RM : DependentTransformable<DM, D>, DM, D> FlowResponse<RM>.mapToDomain(
        dependency: D,
    ): FlowResponse<DM> =
        mapInternal { responseModel ->
            responseModel.transform(dependency)
        }

    /**
     * Mapping the response models to the domain models inside the [FlowResponse].
     * Used generics: RM - ResponseModel, DM - DomainModel.
     *
     * @return the [FlowResponse] with the server response,
     * inside which the data inside the [Response.Success] state
     * mapped from response models to domain models
     */
    fun <RM : SimpleTransformable<DM>, DM> FlowResponse<List<RM>>.mapListToDomain(): FlowResponse<List<DM>> =
        mapListInternal { responseModels ->
            responseModels.map { it.transform() }
        }

    /**
     * Mapping the response models to the domain models inside the [FlowResponse].
     * Used generics: RM - ResponseModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the [FlowResponse] with the server response,
     * inside which the data inside the [Response.Success] state
     * mapped from response models to domain models
     */
    fun <RM : DependentTransformable<DM, D>, DM, D> FlowResponse<List<RM>>.mapListToDomain(
        dependency: D,
    ): FlowResponse<List<DM>> =
        mapListInternal { responseModels ->
            responseModels.map { it.transform(dependency) }
        }

    private fun <RM : Transformable<DM>, DM> FlowResponse<RM>.mapInternal(
        transformer: (responseModel: RM) -> DM,
    ): FlowResponse<DM> =
        map { state -> state.mapResponse(transformer) }

    private fun <RM : Transformable<DM>, DM> FlowResponse<List<RM>>.mapListInternal(
        transformer: (responseModels: List<RM>) -> List<DM>,
    ): FlowResponse<List<DM>> =
        map { state -> state.mapResponse(transformer) }

    private fun <RM, DM> Response<RM>.mapResponse(transformer: (RM) -> DM): Response<DM> =
        when (this) {
            is Response.Success -> Response.Success(data = transformer(getData()))
            is Response.Loading -> this
            is Response.Empty -> this
            is Response.Error -> this
        }
}