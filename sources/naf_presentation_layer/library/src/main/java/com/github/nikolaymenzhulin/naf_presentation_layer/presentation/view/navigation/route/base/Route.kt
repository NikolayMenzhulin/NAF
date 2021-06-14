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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base

/**
 * The base interface for route of the screen.
 */
interface Route {

    /**
     * A set of constants for identifying screen parameters when passing them through route.
     */
    companion object {

        const val EXTRA_FIRST = "EXTRA_FIRST"
        const val EXTRA_SECOND = "EXTRA_SECOND"
        const val EXTRA_THIRD = "EXTRA_THIRD"
        const val EXTRA_FOURTH = "EXTRA_FOURTH"
        const val EXTRA_FIFTH = "EXTRA_FIFTH"
        const val EXTRA_SIXTH = "EXTRA_SIXTH"
        const val EXTRA_SEVENTH = "EXTRA_SEVENTH"
        const val EXTRA_EIGHTH = "EXTRA_EIGHTH"
        const val EXTRA_NINTH = "EXTRA_NINTH"
        const val EXTRA_TENTH = "EXTRA_TENTH"
    }
}