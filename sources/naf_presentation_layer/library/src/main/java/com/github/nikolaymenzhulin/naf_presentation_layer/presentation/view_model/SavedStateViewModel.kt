package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import androidx.lifecycle.SavedStateHandle

/**
 * The base class of a view model with persistence support.
 *
 * @property savedStateHandle the [SavedStateHandle] associated with a view
 */
abstract class SavedStateViewModel : BaseViewModel() {

    protected abstract val savedStateHandle: SavedStateHandle

    /**
     * The callback to save the state of a view model.
     * Called at the onSaveInstantState call of a view, after super.onSaveInstantState call.
     */
    open fun onSaveInstantState() {
        // Empty realization.
    }
}