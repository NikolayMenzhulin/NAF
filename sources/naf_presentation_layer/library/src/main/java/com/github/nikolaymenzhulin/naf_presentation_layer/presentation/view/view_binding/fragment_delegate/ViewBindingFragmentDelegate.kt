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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.fragment_delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingHolder

/**
 * The delegate that contains the common logic for view binding fragments.
 */
internal class ViewBindingFragmentDelegate<VB : ViewBinding>(
    @LayoutRes private val contentLayoutId: Int,
    vbClass: Class<VB>
) {

    internal val vbHolder: ViewBindingHolder<VB> = ViewBindingHolder(vbClass)

    private val vbCreateMethodType: ViewBindingCreateMethodType = if (contentLayoutId == 0) INFLATE else BIND

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?): View? =
        if (vbCreateMethodType == INFLATE) {
            vbHolder.initViewBinding(inflater, container, false)
            vbHolder.vb!!.root
        } else {
            inflater.inflate(contentLayoutId, container, false)
        }

    fun onViewCreated(view: View) {
        if (vbCreateMethodType == BIND) vbHolder.initViewBinding(view)
    }

    fun onDestroyView() {
        vbHolder.clearViewBinding()
    }
}