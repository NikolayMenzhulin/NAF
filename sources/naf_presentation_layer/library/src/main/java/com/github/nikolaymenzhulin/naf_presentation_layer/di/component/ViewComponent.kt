package com.github.nikolaymenzhulin.naf_presentation_layer.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * The base interface for Dagger components that inject dependencies into a view.
 */
interface ViewComponent<V : InjectableView> : DaggerComponent {

    /**
     * Inject dependencies into a view.
     *
     * @param view the view for injection of dependencies
     */
    fun inject(view: V)
}