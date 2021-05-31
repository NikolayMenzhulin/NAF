package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate

/**
 * Базовый класс view model c поддержкой навигации.
 *
 * @property navDelegate делегат, инкапсулирующий логику навигации
 */
abstract class NavigationViewModel<ND : AbstractNavDelegate<*, *>> : CoroutineViewModel() {

    protected abstract val navDelegate: ND

    /**
     * Закрыть экран.
     */
    open fun exit() {
        navDelegate.exit()
    }
}