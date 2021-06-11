package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * The base interface of the assisted factory providing the view model.
 */
interface ViewModelAssistedFactory<VM : ViewModel> {

    /**
     * Create a view model.
     *
     * @param savedStateHandle the [SavedStateHandle] associated with a view
     *
     * @return the created view model
     */
    fun create(savedStateHandle: SavedStateHandle): VM
}