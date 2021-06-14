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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * The base class for the delegate that contains navigation logic.
 *
 * @property route screen route to get passed parameters
 * @property router router for navigating between screens
 */
abstract class AbstractNavDelegate<ROUTER : Router, ROUTE : Route> {

    abstract val route: ROUTE

    protected abstract val router: ROUTER

    /**
     * Close the screen.
     */
    fun exit() {
        router.exit()
    }

    /**
     * Send the result of the screen.
     *
     * @param key a key identifying the result being sent
     * @param screenResult the result of the screen
     */
    protected fun <T : Any> Router.sendScreenResult(key: String, screenResult: T) {
        sendResult(key, screenResult)
    }

    /**
     * Get the result of the screen.
     *
     * @param key a key identifying the received result
     *
     * @return the result of the screen
     */
    protected suspend inline fun <reified T : Any> Router.getScreenResult(key: String): T =
        suspendCancellableCoroutine { continuation ->
            setResultListener(key) { screenResult ->
                continuation.resume(screenResult as T)
            }
        }
}