package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base.ViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * The base class of a dependency injector for a view.
 *
 * @param view the view for injection of dependencies
 */
abstract class AbstractViewInjector<V : InjectableView>(private val view: V) : ViewInjector<V> {

    override fun inject() {
        initComponent()
        getViewComponent().inject(view)
    }
}