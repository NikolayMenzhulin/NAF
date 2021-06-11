package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.Creator

/**
 * Implementation of the [Screen] for dialogs.
 */
interface DialogScreen : Screen {

    fun createDialog(factory: FragmentFactory): DialogFragment

    companion object {

        operator fun invoke(
            key: String? = null,
            fragmentCreator: Creator<FragmentFactory, DialogFragment>
        ): DialogScreen =
            object : DialogScreen {

                override val screenKey: String = key ?: fragmentCreator::class.java.name

                override fun createDialog(factory: FragmentFactory): DialogFragment = fragmentCreator.create(factory)
            }
    }
}