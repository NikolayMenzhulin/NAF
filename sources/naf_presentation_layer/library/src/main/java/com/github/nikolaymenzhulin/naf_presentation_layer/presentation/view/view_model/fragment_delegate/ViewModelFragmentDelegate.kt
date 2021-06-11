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