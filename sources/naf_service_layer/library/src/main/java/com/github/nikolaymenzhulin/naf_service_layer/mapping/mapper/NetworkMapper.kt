package com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.DependentTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.Transformable
import kotlinx.coroutines.flow.map

/**
 * Базовый интерфейс для класса-маппера моделей при работе с сетью.
 */
interface NetworkMapper {

    /**
     * Маппинг response модели в domain модель внутри [FlowResponse].
     * Используемые обобщённые типы: RM - ResponseModel, DM - DomainModel.
     *
     * @return [FlowResponse] c состояниями ответа от сервера, внутри которого
     * был произвёдён маппинг данных внутри состояния [Response.Success]
     * из response модели в domain модель
     */
    fun <RM : SimpleTransformable<DM>, DM> FlowResponse<RM>.mapToDomain(): FlowResponse<DM> =
        mapInternal { responseModel ->
            responseModel.transform()
        }

    /**
     * Маппинг response модели в domain модель внутри [FlowResponse].
     * Используемые обобщённые типы: RM - ResponseModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return [FlowResponse] c состояниями ответа от сервера, внутри которого
     * был произвёдён маппинг данных внутри состояния [Response.Success]
     * из response модели в domain модель
     */
    fun <RM : DependentTransformable<DM, D>, DM, D> FlowResponse<RM>.mapToDomain(
        dependency: D,
    ): FlowResponse<DM> =
        mapInternal { responseModel ->
            responseModel.transform(dependency)
        }

    /**
     * Маппинг response моделей в domain модели внутри [FlowResponse].
     * Используемые обобщённые типы: RM - ResponseModel, DM - DomainModel.
     *
     * @return [FlowResponse] c состояниями ответа от сервера, внутри которого
     * был произвёдён маппинг данных внутри состояния [Response.Success]
     * из response моделей в domain модели
     */
    fun <RM : SimpleTransformable<DM>, DM> FlowResponse<List<RM>>.mapListToDomain(): FlowResponse<List<DM>> =
        mapListInternal { responseModels ->
            responseModels.map { it.transform() }
        }

    /**
     * Маппинг response моделей в domain модели внутри [FlowResponse].
     * Используемые обобщённые типы: RM - ResponseModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return [FlowResponse] c состояниями ответа от сервера, внутри которого
     * был произвёдён маппинг данных внутри состояния [Response.Success]
     * из response моделей в domain модели
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