package com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import dagger.Module
import dagger.Provides

/**
 * Базовый Dagger-модуль, предоставляющий основные зависимости для экрана, основанного на activity.
 */
@Module
abstract class ActivityModule(
    private val activity: FragmentActivity,
    @IdRes private val navHostFragmentId: Int
) : DaggerModule {

    @PerActivity
    @Provides
    fun provideNavController(): NavController {
        val navHostFragment: NavHostFragment =
            activity.supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment

        return navHostFragment.navController
    }

    @PerActivity
    @Provides
    fun provideArguments(): Bundle? = activity.intent.extras

    @PerActivity
    @Provides
    fun provideLifecycleOwner(): LifecycleOwner = activity

    @PerActivity
    @Provides
    fun provideCommonNavigatorDeps(
        navController: NavController,
        arguments: Bundle?,
        lifecycleOwner: LifecycleOwner
    ): CommonNavigatorDeps =
        CommonNavigatorDeps(navController, arguments, lifecycleOwner)
}