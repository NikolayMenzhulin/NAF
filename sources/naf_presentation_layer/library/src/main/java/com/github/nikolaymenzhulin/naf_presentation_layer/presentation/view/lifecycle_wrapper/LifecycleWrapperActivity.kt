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

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.NavigationActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator

/**
 * The base activity that wraps lifecycle methods.
 *
 * @param contentLayoutId the id of the layout for the activity
 * @param vbClass the class of the view binding associated with the activity
 */
abstract class LifecycleWrapperActivity<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : NavigationActivity<VM, VB, N>(contentLayoutId, vbClass) {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateCallback(savedInstanceState)
        onObserveViewModelCallback()
    }

    final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        onCreateCallback(savedInstanceState, persistentState)
        onObserveViewModelCallback()
    }

    final override fun onStart() {
        super.onStart()
        onStartCallback()
    }

    final override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        onRestoreInstanceStateCallback(savedInstanceState)
    }

    final override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        onRestoreInstanceStateCallback(savedInstanceState, persistentState)
    }

    final override fun onResume() {
        super.onResume()
        onResumeCallback()
    }

    final override fun onResumeFragments() {
        super.onResumeFragments()
        onResumeFragmentsCallback()
    }

    final override fun onPause() {
        super.onPause()
        onPauseCallback()
    }

    final override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        onSaveInstanceStateCallback(outState)
    }

    final override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        onSaveInstanceStateCallback(outState, outPersistentState)
    }

    final override fun onStop() {
        super.onStop()
        onStopCallback()
    }

    final override fun onDestroy() {
        super.onDestroy()
        onDestroyCallback()
    }

    protected open fun onCreateCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onCreateCallback(savedInstanceState: Bundle?, persistableBundle: PersistableBundle?) {
        // Empty realization.
    }

    protected open fun onStartCallback() {
        // Empty realization.
    }

    protected open fun onRestoreInstanceStateCallback(savedInstanceState: Bundle) {
        // Empty realization.
    }

    protected open fun onRestoreInstanceStateCallback(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        // Empty realization.
    }

    protected open fun onResumeCallback() {
        // Empty realization.
    }

    protected open fun onResumeFragmentsCallback() {
        // Empty realization.
    }

    protected open fun onPauseCallback() {
        // Empty realization.
    }

    protected open fun onSaveInstanceStateCallback(outState: Bundle) {
        // Empty realization.
    }

    protected open fun onSaveInstanceStateCallback(outState: Bundle, outPersistentState: PersistableBundle) {
        // Empty realization.
    }

    protected open fun onStopCallback() {
        // Empty realization.
    }

    protected open fun onDestroyCallback() {
        // Empty realization.
    }

    /**
     * The callback to subscribe to data from view model.
     * Called at the onCreate call, after calls super.onCreate and onCreateCallback.
     */
    protected abstract fun onObserveViewModelCallback()
}