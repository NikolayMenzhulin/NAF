package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate

/**
 * The base class for implementing a view model with support for persistence, coroutines and navigation.
 */
abstract class AbstractViewModel<ND : AbstractNavDelegate<*, *>> : NavigationViewModel<ND>()