package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel

/**
 * Базовый интерфейс assisted фабрики, предоставляющей navigator.
 */
interface NavigatorAssistedFactory<N : AbstractNavigator<VM>, VM : BaseViewModel> {

    /**
     * Создать navigator.
     *
     * @param vm view model, с которой будет связан созданный navigator
     *
     * @return созданный navigator
     */
    fun create(vm: VM): N
}