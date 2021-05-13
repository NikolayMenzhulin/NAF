package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.TestNavigationFragmentB
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.navigation.fragment_b.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class TestNavigationFragmentBModule(fragment: TestNavigationFragmentB) : FragmentModule(fragment) {

    @PerFragment
    @Provides
    fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
}