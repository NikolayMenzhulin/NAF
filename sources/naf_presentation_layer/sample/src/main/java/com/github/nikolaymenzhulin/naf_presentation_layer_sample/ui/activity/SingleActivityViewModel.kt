package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [SingleActivity].
 */
class SingleActivityViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: SingleActivityNavDelegate
) : AbstractViewModel<SingleActivityNavDelegate>()

@AssistedFactory
interface SingleActivityViewModelFactory : ViewModelAssistedFactory<SingleActivityViewModel>