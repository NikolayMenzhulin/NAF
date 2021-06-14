/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator

import androidx.fragment.app.*
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.DialogScreen
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.FragmentScreen
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.AppNavigator

private typealias CiceroneFragmentScreen = com.github.terrakok.cicerone.androidx.FragmentScreen

/**
* Implementation of the [Navigator] with navigation support for dialogs and with default animation of fragment transactions.
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