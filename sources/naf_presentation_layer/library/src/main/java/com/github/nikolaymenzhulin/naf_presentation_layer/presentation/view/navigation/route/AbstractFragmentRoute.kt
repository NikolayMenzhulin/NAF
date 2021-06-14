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

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.fragment.app.Fragment
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.FragmentScreen
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route

/**
 * The base route class for the fragment-based screen.
 */
abstract class AbstractFragmentRoute<F : Fragment> : Route {

    /**
     * Create a fragment for the screen to open.
     *
     * @return the fragment for the screen to open
     */
    protected abstract fun getFragment(): F

    /**
     * Create an [FragmentScreen] for the screen to open.
     *
     * @param key key identifying the screen to open
     * @param clearContainer whether to replace the current open screen with an openable one
     * @param enterAnimResId animation of the fragment to which we go
     * @param exitAnimResId animation of the fragment from which we move
     * @param popEnterAnimResId animation of the fragment to which we return
     * @param popExitAnimResId animation of the fragment from which we return
     *
     * @return the [FragmentScreen] for the screen to open
     */
    operator fun invoke(
        key: String = this::class.java.name,
        clearContainer: Boolean = true,
        @AnimatorRes @AnimRes enterAnimResId: Int? = R.anim.base_enter,
        @AnimatorRes @AnimRes exitAnimResId: Int? = R.anim.base_exit,
        @AnimatorRes @AnimRes popEnterAnimResId: Int? = R.anim.base_pop_enter,
        @AnimatorRes @AnimRes popExitAnimResId: Int? = R.anim.base_pop_exit,
    ): FragmentScreen =
        FragmentScreen(
            key,
            clearContainer,
            enterAnimResId,
            exitAnimResId,
            popEnterAnimResId,
            popExitAnimResId
        ) { getFragment() }
}