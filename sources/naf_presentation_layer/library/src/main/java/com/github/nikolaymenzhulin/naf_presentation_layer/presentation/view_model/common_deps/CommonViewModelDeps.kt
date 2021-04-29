package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * Класс, содержащий основные зависимости, которые необходимы view model.
 *
 * @param savedStateHandle [SavedStateHandle], связанный c view
 * @param defaultErrorHandler дефолтный обработчик ошибок
 */
class CommonViewModelDeps @AssistedInject constructor(
    @Assisted val savedStateHandle: SavedStateHandle,
    val defaultErrorHandler: ErrorHandler
) {

    /**
     * Базовый интерфейс assisted фабрики, предоставляющей [CommonViewModelDeps].
     */
    @AssistedFactory
    interface Factory {

        /**
         * Создать [CommonViewModelDeps].
         *
         * @param savedStateHandle [SavedStateHandle], связанный c view
         *
         * @return созданный [CommonViewModelDeps]
         */
        fun create(savedStateHandle: SavedStateHandle): CommonViewModelDeps
    }
}