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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.fragment_delegate.ViewBindingFragmentDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelDialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base dialog fragment with support for working with a view binding.
 *
 * @param contentLayoutId the id of the layout for the dialog fragment
 * @param vbClass the class of the view binding associated with the dialog fragment
 *
 * @property vb the view binding associated with the dialog fragment
 */
abstract class ViewBindingDialogFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelDialogFragment<VM>() {

    protected val vb: VB
        get() = delegate.vbHolder.vb
            ?: throw IllegalStateException("The view binding available only when a view of a dialog fragment is inflated")

    private val delegate by lazy { ViewBindingFragmentDelegate<VB>(contentLayoutId, vbClass) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        delegate.onCreateView(inflater, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        delegate.onViewCreated(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        delegate.onDestroyView()
    }
}