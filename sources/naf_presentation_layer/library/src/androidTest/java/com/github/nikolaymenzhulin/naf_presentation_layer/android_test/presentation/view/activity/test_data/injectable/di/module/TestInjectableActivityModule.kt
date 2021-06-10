package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.InjectableActivityTest.Companion.DEPENDENCY_STRING
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class TestInjectableActivityModule : DaggerModule {

    @PerActivity
    @Provides
    fun provideViewDependency(): String = DEPENDENCY_STRING
}