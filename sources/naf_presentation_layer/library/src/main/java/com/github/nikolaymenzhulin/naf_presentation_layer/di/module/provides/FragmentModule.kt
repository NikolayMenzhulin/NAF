package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import dagger.Module
import dagger.Provides

/**
 * Базовый Dagger-модуль, предоставляющий основные зависимости для экрана, основанного на fragment.
 */
@Module
abstract class FragmentModule(private val fragment: Fragment) : DaggerModule {

    @PerFragment
    @Provides
    fun provideNavController(): NavController = Navigation.findNavController(fragment.requireView())

    @PerFragment
    @Provides
    fun provideArguments(): Bundle? = fragment.arguments

    @PerFragment
    @Provides
    fun provideLifecycleOwner(): LifecycleOwner = fragment

    @PerFragment
    @Provides
    fun provideCommonNavigatorDeps(
        navController: NavController,
        arguments: Bundle?,
        lifecycleOwner: LifecycleOwner
    ): CommonNavigatorDeps =
        CommonNavigatorDeps(navController, arguments, lifecycleOwner)
}