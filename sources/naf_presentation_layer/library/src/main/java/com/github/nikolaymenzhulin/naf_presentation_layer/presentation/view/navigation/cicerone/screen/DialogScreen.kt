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