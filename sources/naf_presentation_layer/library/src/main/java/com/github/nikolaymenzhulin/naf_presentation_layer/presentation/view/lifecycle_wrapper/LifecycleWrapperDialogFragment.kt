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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.lifecycle_wrapper

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingDialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base dialog fragment that wraps lifecycle methods.
 *
 * @param contentLayoutId the id of the layout for the dialog fragment
 * @param vbClass the class of the view binding associated with the dialog fragment
 */
abstract class LifecycleWrapperDialogFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingDialogFragment<VM, VB>(contentLayoutId, vbClass) {

    final override fun onAttach(context: Context) {
        super.onAttach(context)
        onAttachCallback(context)
    }

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateCallback(savedInstanceState)
    }

    final override fun onActivityCreate() {
        super.onActivityCreate()
        onActivityCreateCallback()
    }

    final override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        onCreateDialogCallback(savedInstanceState)

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        super.onCreateView(inflater, container, savedInstanceState)

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreatedCallback(view, savedInstanceState)
        onObserveViewModelCallback()
    }

    @Suppress("DEPRECATION")
    final override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onActivityCreatedCallback(savedInstanceState)
    }

    final override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        onViewStateRestoredCallback(savedInstanceState)
    }

    final override fun onStart() {
        super.onStart()
        onStartCallback()
    }

    final override fun onResume() {
        super.onResume()
        onResumeCallback()
    }

    final override fun onPause() {
        super.onPause()
        onPauseCallback()
    }

    final override fun onStop() {
        super.onStop()
        onStopCallback()
    }

    final override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        onSaveInstanceStateCallback(outState)
    }

    final override fun onDestroyView() {
        super.onDestroyView()
        onDestroyViewCallback()
    }

    final override fun onDestroy() {
        super.onDestroy()
        onDestroyCallback()
    }

    final override fun onDetach() {
        super.onDetach()
        onDetachCallback()
    }

    protected open fun onAttachCallback(context: Context) {
        // Empty realization.
    }

    protected open fun onCreateCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onActivityCreateCallback() {
        // Empty realization.
    }

    protected open fun onCreateDialogCallback(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    protected open fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onActivityCreatedCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onViewStateRestoredCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onStartCallback() {
        // Empty realization.
    }

    protected open fun onResumeCallback() {
        // Empty realization.
    }

    protected open fun onPauseCallback() {
        // Empty realization.
    }

    protected open fun onStopCallback() {
        // Empty realization.
    }

    protected open fun onSaveInstanceStateCallback(outState: Bundle) {
        // Empty realization.
    }

    protected open fun onDestroyViewCallback() {
        // Empty realization.
    }

    protected open fun onDestroyCallback() {
        // Empty realization.
    }

    protected open fun onDetachCallback() {
        // Empty realization.
    }

    /**
     * The callback to subscribe to data from view model.
     * Called at the onViewCreated call, after calls super.onViewCreated and onViewCreatedCallback.
     */
    protected abstract fun onObserveViewModelCallback()
}