package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator

import androidx.fragment.app.*
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.DialogScreen
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.FragmentScreen
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.AppNavigator

private typealias CiceroneFragmentScreen = com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Реализация [Navigator] с поддержкой навигации для dialog'ов и с дефолтной анимацией транзакций fragment'ов.
 */
open class ScreenNavigator @JvmOverloads constructor(
    activity: FragmentActivity,
    containerId: Int = 0,
    fragmentManager: FragmentManager = activity.supportFragmentManager,
    fragmentFactory: FragmentFactory = fragmentManager.fragmentFactory
) : AppNavigator(activity, containerId, fragmentManager, fragmentFactory) {

    override fun forward(command: Forward) {
        val screen: Screen = command.screen
        when {
            screen is DialogScreen -> openDialogScreen(screen)
            screen is FragmentScreen && containerId == 0 -> throwEmptyFragmentsContainerError()
            else -> super.forward(command)
        }
    }

    override fun replace(command: Replace) {
        val screen: Screen = command.screen
        when {
            screen is DialogScreen -> throwNotImplementedCommandError(command)
            screen is FragmentScreen && containerId == 0 -> throwEmptyFragmentsContainerError()
            else -> super.replace(command)
        }
    }

    override fun backTo(command: BackTo) {
        val screen: Screen? = command.screen
        if (screen is DialogScreen) {
            throwNotImplementedCommandError(command)
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

    override fun setupFragmentTransaction(
        screen: CiceroneFragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        with(screen) {
            if (this is FragmentScreen) {
                fragmentTransaction.setCustomAnimations(
                    enterAnimResId ?: 0,
                    exitAnimResId ?: 0,
                    popEnterAnimResId ?: 0,
                    popExitAnimResId ?: 0
                )
            }
        }
    }

    private fun openDialogScreen(screen: DialogScreen) {
        val dialogFragment: DialogFragment = screen.createDialog(fragmentFactory)
        dialogFragment.show(fragmentManager, screen.screenKey)
    }

    private fun throwNotImplementedCommandError(command: Command) {
        throw NotImplementedError("Command ${command::class.simpleName} not supported for dialogs")
    }

    private fun throwEmptyFragmentsContainerError() {
        throw IllegalStateException("containerId value for this navigator is unset = $containerId")
    }
}