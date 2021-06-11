package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route

import androidx.fragment.app.DialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.DialogScreen
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route

/**
 * The base route class for the dialog-based screen.
 */
abstract class AbstractDialogFragmentRoute<D : DialogFragment> : Route {

    /**
     * Create a dialog for the screen to open.
     *
     * @return the dialog for the screen to open
     */
    protected abstract fun getDialog(): D

    /**
     * Create an [DialogScreen] for the screen to open.
     *
     * @param key key identifying the screen to open
     *
     * @return the [DialogScreen] for the screen to open
     */
    operator fun invoke(key: String = this::class.java.name): DialogScreen =
        DialogScreen(key) { getDialog() }
}