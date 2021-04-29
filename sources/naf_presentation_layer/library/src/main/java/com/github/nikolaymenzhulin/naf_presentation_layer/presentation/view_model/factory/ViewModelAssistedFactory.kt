package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory

import androidx.lifecycle.ViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps

/**
 * Базовый интерфейс assisted фабрики, предоставляющей view model.
 */
interface ViewModelAssistedFactory<VM : ViewModel> {

    /**
     * Создать view model.
     *
     * @param commonDeps [CommonViewModelDeps] для создаваемой view model
     *
     * @return созданная view model
     */
    fun create(commonDeps: CommonViewModelDeps): VM
}