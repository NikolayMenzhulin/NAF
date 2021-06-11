package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds

import androidx.lifecycle.ViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.Binds
import dagger.Module

/**
 * The base Dagger module that provides a factory for producing a view model.
 */
@Module
interface BaseViewModelFactoryModule<F : ViewModelAssistedFactory<*>> : DaggerModule {

    @Binds
    fun bindViewModelFactory(factory: F): ViewModelAssistedFactory<out ViewModel>
}