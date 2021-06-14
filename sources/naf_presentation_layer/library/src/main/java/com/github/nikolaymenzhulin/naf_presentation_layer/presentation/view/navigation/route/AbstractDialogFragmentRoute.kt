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