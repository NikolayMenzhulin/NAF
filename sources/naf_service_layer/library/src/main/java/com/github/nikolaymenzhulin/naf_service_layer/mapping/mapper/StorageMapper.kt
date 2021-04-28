package com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.DependentTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import kotlinx.coroutines.flow.*

/**
 * Базовый интерфейс для класса-маппера моделей при работе с хранилищами (база данных, кэш и т. д.).
 */
interface StorageMapper {

    /**
     * Маппинг storage модели в domain модель.
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel.
     *
     * @return модель, преобразованная из storage модели в domain модель
     */
    fun <SM : SimpleTransformable<DM>, DM> SM?.mapToDomain(): DM? = this?.transform()

    /**
     * Маппинг storage модели в domain модель.
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return модель, преобразованная из storage модели в domain модель
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> SM?.mapToDomain(dependency: D): DM? = this?.transform(dependency)

    /**
     * Маппинг списка storage моделей в список domain моделей.
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel.
     *
     * @return список, внутри которого был произведён маппинг данных из storage моделей в domain модели
     */
    fun <SM : SimpleTransformable<DM>, DM> List<SM>?.mapListToDomain(): List<DM> =
        this?.map { storageModel -> storageModel.transform() } ?: emptyList()

    /**
     * Маппинг списка storage моделей в список domain моделей.
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return список, внутри которого был произведён маппинг данных из storage моделей в domain модели
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> List<SM>?.mapListToDomain(
        dependency: D,
    ): List<DM> =
        this?.map { storageModel -> storageModel.transform(dependency) } ?: emptyList()

    /**
     * Маппинг storage модели в domain модель внутри [Flow].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel.
     *
     * @return [Flow] внутри которого был произведён маппинг данных из storage модели в domain модель
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<SM?>.mapToDomain(): Flow<DM?> =
        map { storageModel -> storageModel?.transform() }

    /**
     * Маппинг storage модели в domain модель внутри [Flow].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return [Flow] внутри которого был произведён маппинг данных из storage модели в domain модель
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<SM?>.mapToDomain(
        dependency: D,
    ): Flow<DM?> =
        map { storageModel -> storageModel?.transform(dependency) }

    /**
     * Маппинг списка storage моделей в список domain моделей внутри [Flow].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel.
     *
     * @return [Flow] внутри которого был произведён маппинг данных из storage моделей в domain модели
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<List<SM>?>.mapListToDomain(): Flow<List<DM>> =
        map { storageModels -> storageModels?.map { it.transform() } ?: emptyList() }

    /**
     * Маппинг списка storage моделей в список domain моделей внутри [Flow].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return [Flow] внутри которого был произведён маппинг данных из storage моделей в domain модели
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<List<SM>?>.mapListToDomain(
        dependency: D,
    ): Flow<List<DM>> =
        map { storageModels -> storageModels?.map { it.transform(dependency) } ?: emptyList() }

    /**
     * Маппинг storage модели в domain модель внутри [Flow] и заворачивание результата в [Response].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel.
     *
     * @return [FlowResponse] c состоянием ответа от хранилища, внутри которого
     * был произведён маппинг данных внутри состояния [Response.Success]
     * из storage модели в domain модель
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<SM?>.mapToDomainResponse(): FlowResponse<DM> =
        mapToDomain().wrapToResponse()

    /**
     * Маппинг storage модели в domain модель внутри [Flow] и заворачивание результата в [Response].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return [FlowResponse] c состоянием ответа от хранилища, внутри которого
     * был произведён маппинг данных внутри состояния [Response.Success]
     * из storage модели в domain модель
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<SM?>.mapToDomainResponse(
        dependency: D,
    ): FlowResponse<DM> =
        mapToDomain(dependency).wrapToResponse()

    /**
     * Маппинг списка storage моделей в список domain моделей внутри [Flow] и заворачивание результата в [Response].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel.
     *
     * [FlowResponse] c состоянием ответа от хранилища, внутри которого
     * был произведён маппинг данных внутри состояния [Response.Success]
     * из storage моделей в domain модели
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<List<SM>?>.mapListToDomainResponse(): FlowResponse<List<DM>> =
        mapListToDomain().wrapToResponse()

    /**
     * Маппинг списка storage моделей в список domain моделей внутри [Flow] и заворачивание результата в [Response].
     * Используемые обобщённые типы: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * [FlowResponse] c состоянием ответа от хранилища, внутри которого
     * был произведён маппинг данных внутри состояния [Response.Success]
     * из storage моделей в domain модели
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<List<SM>?>.mapListToDomainResponse(
        dependency: D,
    ): FlowResponse<List<DM>> =
        mapListToDomain(dependency).wrapToResponse()

    private fun <T> Flow<T?>.wrapToResponse(): FlowResponse<T> = this
        .transform { data ->
            val isEmptyList: Boolean = (data as? List<*>)?.isEmpty() ?: false
            emit(
                if (data != null && !isEmptyList) {
                    Response.Success(data = data)
                } else {
                    Response.Empty
                }
            )
        }
        .onStart { emit(Response.Loading) }
        .catch { throwable -> emit(Response.Error(error = throwable)) }
        .take(2)
}