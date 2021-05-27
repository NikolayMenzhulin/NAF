package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator

import androidx.fragment.app.*
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.DialogScreen
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.AppNavigator

/**
 * Реализация [Navigator] с поддержкой навигации для dialog fragment'ов и bottom sheet fragment'ов.
 */
open class ScreenNavigator @JvmOverloads constructor(
    activity: FragmentActivity,
    containerId: Int,
    fragmentManager: FragmentManager = activity.supportFragmentManager,
    fragmentFactory: FragmentFactory = fragmentManager.fragmentFactory
) : AppNavigator(activity, containerId, fragmentManager, fragmentFactory) {

    override fun forward(command: Forward) {
        val screen: Screen = command.screen
        if (screen is DialogScreen) {
            openDialog(screen)
        } else {
            super.forward(command)
        }
    }

    override fun replace(command: Replace) {
        val screen: Screen = command.screen
        if (screen is DialogScreen) {
            throwNotImplementedCommand(command)
        } else {
            super.replace(command)
        }
    }

    override fun backTo(command: BackTo) {
        val screen: Screen? = command.screen
        if (screen is DialogScreen) {
            throwNotImplementedCommand(command)
        } else {
            super.backTo(command)
        }
    }

    override fun back() {
        val fragment: Fragment? = fragmentManager.fragments.lastOrNull()
        if (fragment != null && fragment is DialogFragment) {
            fragment.dismiss()
        } else {
            super.back()
        }
    }

    private fun openDialog(screen: DialogScreen) {
        val dialogFragment: DialogFragment = screen.createDialog(fragmentFactory)
        dialogFragment.show(fragmentManager, screen.screenKey)
    }

    private fun throwNotImplementedCommand(command: Command) {
        throw NotImplementedError("Command ${command::class.simpleName} not supported for an dialog fragment/bottom sheet fragment")
    }
}