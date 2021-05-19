package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.InjectableFragmentTest.Companion.DEPENDENCY_STRING
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import dagger.Module
import dagger.Provides

@Module
class TestInjectableFragmentModule : DaggerModule {

    @PerFragment
    @Provides
    fun provideViewDependency(): String = DEPENDENCY_STRING
}