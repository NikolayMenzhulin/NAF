package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * Базовый интерфейс assisted фабрики, предоставляющей view model.
 */
interface ViewModelAssistedFactory<VM : ViewModel> {

    /**
     * Создать view model.
     *
     * @param savedStateHandle [SavedStateHandle], связанный c view
     *
     * @return созданная view model
     */
    fun create(savedStateHandle: SavedStateHandle): VM
}