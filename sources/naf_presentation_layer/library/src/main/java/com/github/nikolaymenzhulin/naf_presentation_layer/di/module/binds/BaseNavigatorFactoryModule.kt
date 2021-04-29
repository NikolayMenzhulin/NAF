package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import dagger.Binds
import dagger.Module

/**
 * Базовый Dagger-модуль, предоставляющий фабрику для производства navigator.
 */
@Module
interface BaseNavigatorFactoryModule<F : NavigatorAssistedFactory<N, VM>, N : AbstractNavigator<VM>, VM : BaseViewModel> :
    DaggerModule {

    @Binds
    fun bindNavigatorFactory(factory: F): NavigatorAssistedFactory<N, VM>
}