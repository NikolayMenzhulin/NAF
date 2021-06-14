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
package com.github.nikolaymenzhulin.naf_presentation_layer.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule

/**
 * The base class for a holder of a Dagger component.
 *
 * @property component the component that contains inside a holder
 */
abstract class AbstractComponentHolder<C : DaggerComponent, M : DaggerModule> {

    val component: C
        get() = _component ?: throw IllegalStateException("The component isn't initialized")

    private var _component: C? = null

    /**
     * Initialize the [component].
     *
     * @param module the Dagger module to be used when creating the [component]
     */
    fun initComponent(module: M) {
        _component = getComponentImpl(module)
    }

    /**
     * Clear the [component] that contains inside a holder.
     */
    fun clearComponent() {
        _component = null
    }

    /**
     * Get a component for saving inside a holder.
     *
     * @param module the Dagger module to be used when creating the [component]
     *
     * @return the component for saving inside a holder
     */
    protected abstract fun getComponentImpl(module: M): C
}