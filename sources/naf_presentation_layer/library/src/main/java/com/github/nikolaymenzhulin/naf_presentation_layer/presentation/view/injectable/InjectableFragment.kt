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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable

import android.content.Context
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.fragment_delegate.InjectableFragmentDelegate

/**
 * The base fragment with support for dependency injection.
 */
abstract class InjectableFragment : Fragment(), InjectableView, LifecycleObserver {

    private val delegate by lazy { InjectableFragmentDelegate(this) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate.onAttach()
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }

    /**
     * The callback that called after the onCreate call of the parent activity of the fragment.
     */
    @CallSuper
    @OnLifecycleEvent(ON_CREATE)
    protected open fun onActivityCreate() {
        delegate.onActivityCreate()
    }
}