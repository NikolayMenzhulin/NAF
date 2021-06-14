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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.fragment_delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * The delegate that contains the common logic for injectable fragments.
 */
internal class InjectableFragmentDelegate<T>(
    private val fragment: T
) where T : Fragment, T : InjectableView, T : LifecycleObserver {

    fun onAttach() {
        fragment.requireActivity().lifecycle.addObserver(fragment)
    }

    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        @LayoutRes contentLayoutId: Int
    ): View? =
        inflater.inflate(contentLayoutId, container, false)

    fun onActivityCreate() {
        fragment.requireActivity().lifecycle.removeObserver(fragment)
        fragment.injector.inject()
    }

    fun onDestroy() {
        fragment.injector.clearComponent()
    }
}