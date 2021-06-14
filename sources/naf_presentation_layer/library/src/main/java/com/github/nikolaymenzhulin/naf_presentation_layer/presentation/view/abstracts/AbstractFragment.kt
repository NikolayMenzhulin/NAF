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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.lifecycle_wrapper.LifecycleWrapperFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator

/**
 * The base class for implementing a fragment with support for
 * dependency injection, working with the view model, view binding and Cicerone navigation.
 *
 * @param contentLayoutId the id of the layout for the fragment
 * @param vbClass the class of the view binding associated with the fragment
 */
abstract class AbstractFragment<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperFragment<VM, VB, N>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}