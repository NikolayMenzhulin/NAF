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
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base activity with support for working with a view binding.
 *
 * @param contentLayoutId the id of the layout for the activity
 * @param vbClass the class of the view binding associated with the activity
 *
 * @property vb the view binding associated with the activity
 * @property vbCreateMethodType the creation type of the view binding
 */
abstract class ViewBindingActivity<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelActivity<VM>(contentLayoutId) {

    protected val vb: VB
        get() = vbHolder.vb
            ?: throw IllegalStateException("The view binding has not been initialized yet")

    private var vbHolder: ViewBindingHolder<VB> = ViewBindingHolder(vbClass)

    private val vbCreateMethodType: ViewBindingCreateMethodType = if (contentLayoutId == 0) INFLATE else BIND

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initViewBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        vbHolder.clearViewBinding()
    }

    private fun initViewBinding() {
        if (vbCreateMethodType == INFLATE) {
            vbHolder.initViewBinding(layoutInflater)
            setContentView(vb.root)
        } else {
            val rootView: View = findViewById<ViewGroup?>(android.R.id.content).run { getChildAt(0) }
            vbHolder.initViewBinding(rootView)
        }
    }
}