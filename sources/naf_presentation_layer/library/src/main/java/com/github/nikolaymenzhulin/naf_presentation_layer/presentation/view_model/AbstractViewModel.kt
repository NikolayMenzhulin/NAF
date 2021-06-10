package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate

/**
 * Базовый класс для реализации view model с поддержкой сохранения состояния, работы с корутинами и навигации.
 */
abstract class AbstractViewModel<ND : AbstractNavDelegate<*, *>> : NavigationViewModel<ND>()