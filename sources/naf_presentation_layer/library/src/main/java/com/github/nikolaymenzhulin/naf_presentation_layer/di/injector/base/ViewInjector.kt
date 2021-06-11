package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * The base interface for a class is a dependency injector in a view.
 */
internal interface ViewInjector<V : InjectableView> : Injector {

    /**
     * Initialize the Dagger component for a view.
     */
    fun initComponent()

    /**
     * Get the Dagger component for a view that will be used for dependency injection.
     *
     * @return the component for the view
     */
    fun getViewComponent(): ViewComponent<V>

    /**
     * Clear the Dagger component for a view.
     */
    fun clearComponent()
}