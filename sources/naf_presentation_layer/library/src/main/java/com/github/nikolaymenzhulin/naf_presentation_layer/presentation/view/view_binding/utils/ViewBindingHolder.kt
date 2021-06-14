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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * The holder class for the view binding.
 *
 * @param vbClass the class of the view binding that contains inside a holder
 *
 * @property vb the view binding that contains inside a holder
 */
@Suppress("UNCHECKED_CAST")
internal class ViewBindingHolder<VB : ViewBinding>(private val vbClass: Class<VB>) {

    var vb: VB? = null
        private set

    /**
     * Initialize the [vb] using inflate method.
     */
    fun initViewBinding(layoutInflater: LayoutInflater) {
        if (vb != null) return
        val inflate = vbClass.getMethod("inflate", LayoutInflater::class.java)
        vb = inflate.invoke(null, layoutInflater) as VB
    }

    /**
     * Initialize the [vb] using inflate method.
     */
    fun initViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup? = null, attachToParent: Boolean) {
        if (vb != null) return
        val inflate = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        vb = inflate.invoke(null, layoutInflater, parent, attachToParent) as VB
    }

    /**
     * Initialize the [vb] using inflate bind.
     */
    fun initViewBinding(view: View) {
        if (vb != null) return
        val bind = vbClass.getMethod("bind", View::class.java)
        vb = bind.invoke(null, view) as VB
    }

    /**
     * Clear the [vb] that contains inside a holder.
     */
    fun clearViewBinding() {
        vb = null
    }
}