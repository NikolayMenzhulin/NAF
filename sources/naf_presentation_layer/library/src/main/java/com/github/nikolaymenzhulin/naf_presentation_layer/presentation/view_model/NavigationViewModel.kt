package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate

/**
 * The base class of a view model with navigation support.
 *
 * @property navDelegate the delegate that contains the navigation logic
 */
abstract class NavigationViewModel<ND : AbstractNavDelegate<*, *>> : CoroutineViewModel() {

    protected abstract val navDelegate: ND

    /**
     * Close the screen.
     */
    open fun exit() {
        navDelegate.exit()
    }
}