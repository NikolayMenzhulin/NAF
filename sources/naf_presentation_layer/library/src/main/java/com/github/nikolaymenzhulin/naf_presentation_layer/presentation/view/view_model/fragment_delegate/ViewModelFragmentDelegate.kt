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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.fragment_delegate

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.SavedStateViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.Job

/**
 * The delegate that contains the common logic for view model fragments.
 */
internal class ViewModelFragmentDelegate(private val fragment: Fragment) {

    private val coroutineJobs: MutableList<Job> = mutableListOf()

    fun addCoroutineJob(job: Job) {
        coroutineJobs.add(job)
    }

    fun getDefaultViewModelProviderFactory(
        vmFactory: ViewModelFactory.Factory
    ): ViewModelProvider.Factory =
        with(fragment) { vmFactory.create(this, arguments) }

    fun <VM : BaseViewModel> onSaveInstantState(vm: VM) {
        (vm as? SavedStateViewModel)?.onSaveInstantState()
    }

    fun onDestroyView() {
        coroutineJobs.apply {
            forEach(Job::cancel)
            clear()
        }
    }
}