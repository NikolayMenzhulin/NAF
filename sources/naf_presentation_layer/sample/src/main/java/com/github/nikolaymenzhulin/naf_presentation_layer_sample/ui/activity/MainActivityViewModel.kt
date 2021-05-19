package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [MainActivity].
 */
class MainActivityViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps
) : AbstractViewModel(commonDeps)

@AssistedFactory
interface MainActivityViewModelFactory : ViewModelAssistedFactory<MainActivityViewModel>