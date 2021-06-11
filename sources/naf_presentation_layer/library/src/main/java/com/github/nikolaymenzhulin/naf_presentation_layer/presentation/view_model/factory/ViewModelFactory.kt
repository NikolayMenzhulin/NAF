package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * The factory for creating a view model.
 *
 * @param owner view, which contains the saved state of the view model
 * @param defaultArgs arguments received from the previous screen in the navigation stack
 * @param viewModelAssistedFactory assisted factory to create the view model
 */
class ViewModelFactory @AssistedInject constructor(
    @Assisted owner: SavedStateRegistryOwner,
    @Assisted defaultArgs: Bundle?,
    private val viewModelAssistedFactory: ViewModelAssistedFactory<out ViewModel>
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    /**
     * The base interface of the assisted factory providing the factory for creating a view model.
     */
    @AssistedFactory
    interface Factory {

        /**
         * Create a [ViewModelFactory].
         *
         * @param owner view, which contains the saved state of the view model
         * @param defaultArgs arguments received from the previous screen in the navigation stack
         *
         * @return the created [ViewModelFactory]
         */
        fun create(owner: SavedStateRegistryOwner, defaultArgs: Bundle?): ViewModelFactory
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T =
        viewModelAssistedFactory.create(handle) as T
}