package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps

/**
 * Базовый класс для реализации view model с поддержкой сохранения состояния и обработки ошибок.
 *
 * @param commonDeps основные зависимости, которые необходимы view model
 */
abstract class AbstractViewModel(commonDeps: CommonViewModelDeps) : ErrorHandlingViewModel(commonDeps)