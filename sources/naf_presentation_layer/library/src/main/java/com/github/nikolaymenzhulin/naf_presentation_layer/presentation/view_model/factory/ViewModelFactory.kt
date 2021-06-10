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
 * Фабрика для создания view model.
 *
 * @param owner view, которая содержит сохранённое состояние view model
 * @param defaultArgs аргументы, полученные от предыдущего экрана в стэке навигации
 * @param viewModelAssistedFactory assisted фабрика для создания view model
 */
class ViewModelFactory @AssistedInject constructor(
    @Assisted owner: SavedStateRegistryOwner,
    @Assisted defaultArgs: Bundle?,
    private val viewModelAssistedFactory: ViewModelAssistedFactory<out ViewModel>
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    /**
     * Базовый интерфейс assisted фабрики, предоставляющей фабрику для создания view model.
     */
    @AssistedFactory
    interface Factory {

        /**
         * Создать [ViewModelFactory].
         *
         * @param owner view, которая содержит сохранённое состояние view model
         * @param defaultArgs аргументы, полученные от предыдущего экрана в стэке навигации
         *
         * @return созданная [ViewModelFactory]
         */
        fun create(owner: SavedStateRegistryOwner, defaultArgs: Bundle?): ViewModelFactory
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T =
        viewModelAssistedFactory.create(handle) as T
}