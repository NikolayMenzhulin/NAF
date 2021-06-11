package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base

import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

/**
 * The base interface for a view with support for dependency injection.
 *
 * @property injector dependency injector for the view
 */
interface InjectableView {

    val injector: AbstractViewInjector<*>
}