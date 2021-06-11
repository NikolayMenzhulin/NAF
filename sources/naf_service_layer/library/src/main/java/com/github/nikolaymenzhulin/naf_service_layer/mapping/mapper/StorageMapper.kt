package com.github.nikolaymenzhulin.naf_service_layer.mapping.mapper

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.DependentTransformable
import com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable.SimpleTransformable
import kotlinx.coroutines.flow.*

/**
 * The base interface for a mapper class that maps models when working with storages (database, cache, etc.).
 */
interface StorageMapper {

    /**
     * Mapping the storage model to the domain model.
     * Used generics: SM - StorageModel, DM - DomainModel.
     *
     * @return the model that mapped from the storage model to the domain model
     */
    fun <SM : SimpleTransformable<DM>, DM> SM?.mapToDomain(): DM? = this?.transform()

    /**
     * Mapping the storage model to the domain model.
     * Used generics: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the model that mapped from the storage model to the domain model
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> SM?.mapToDomain(dependency: D): DM? = this?.transform(dependency)

    /**
     * Mapping a list of storage models to a list of domain models.
     * Used generics: SM - StorageModel, DM - DomainModel.
     *
     * @return a list, inside which storage models mapped to domain models
     */
    fun <SM : SimpleTransformable<DM>, DM> List<SM>?.mapListToDomain(): List<DM> =
        this?.map { storageModel -> storageModel.transform() } ?: emptyList()

    /**
     * Mapping a list of storage models to a list of domain models.
     * Used generics: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return a list, inside which storage models mapped to domain models
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> List<SM>?.mapListToDomain(
        dependency: D,
    ): List<DM> =
        this?.map { storageModel -> storageModel.transform(dependency) } ?: emptyList()

    /**
     * Mapping the storage model to the domain model inside the [Flow].
     * Used generics: SM - StorageModel, DM - DomainModel.
     *
     * @return the [Flow], inside which the storage model mapped to the domain model
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<SM?>.mapToDomain(): Flow<DM?> =
        map { storageModel -> storageModel?.transform() }

    /**
     * Mapping the storage model to the domain model inside the [Flow].
     * Used generics: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the [Flow], inside which the storage model mapped to the domain model
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<SM?>.mapToDomain(
        dependency: D,
    ): Flow<DM?> =
        map { storageModel -> storageModel?.transform(dependency) }

    /**
     * Mapping a list of storage models to a list of domain models inside the [Flow].
     * Used generics: SM - StorageModel, DM - DomainModel.
     *
     * @return the [Flow], inside which storage models mapped to domain models
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<List<SM>?>.mapListToDomain(): Flow<List<DM>> =
        map { storageModels -> storageModels?.map { it.transform() } ?: emptyList() }

    /**
     * Mapping a list of storage models to a list of domain models inside the [Flow].
     * Used generics: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the [Flow], inside which storage models mapped to domain models
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<List<SM>?>.mapListToDomain(
        dependency: D,
    ): Flow<List<DM>> =
        map { storageModels -> storageModels?.map { it.transform(dependency) } ?: emptyList() }

    /**
     * Mapping the storage model to the domain model inside the [Flow] and wrapping the result to the [Response].
     * Used generics: SM - StorageModel, DM - DomainModel.
     *
     * @return the [FlowResponse] with the storage response,
     * inside which the data inside the [Response.Success] state
     * mapped from the storage model to the domain model
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<SM?>.mapToDomainResponse(): FlowResponse<DM> =
        mapToDomain().wrapToResponse()

    /**
     * Mapping the storage model to the domain model inside the [Flow] and wrapping the result to the [Response].
     * Used generics: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the [FlowResponse] with the storage response,
     * inside which the data inside the [Response.Success] state
     * mapped from the storage model to the domain model
     */
    fun <SM : DependentTransformable<DM, D>, DM, D> Flow<SM?>.mapToDomainResponse(
        dependency: D,
    ): FlowResponse<DM> =
        mapToDomain(dependency).wrapToResponse()

    /**
     * Mapping a list of storage models to a list of domain models inside the [Flow] and wrapping the result to the [Response].
     * Used generics: SM - StorageModel, DM - DomainModel.
     *
     * @return the [FlowResponse] with the storage response,
     * inside which the data inside the [Response.Success] state
     * mapped from storage models to domain models
     */
    fun <SM : SimpleTransformable<DM>, DM> Flow<List<SM>?>.mapListToDomainResponse(): FlowResponse<List<DM>> =
        mapListToDomain().wrapToResponse()

    /**
     * Mapping a list of storage models to a list of domain models inside the [Flow] and wrapping the result to the [Response].
     * Used generics: SM - StorageModel, DM - DomainModel, D - Dependency.
     *
     * @param dependency dependency required to implement mapping
     *
     * @return the [FlowResponse] with the storage response,
     * inside which the data inside the [Response.Success] state
     * mapped from storage models to domain models
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