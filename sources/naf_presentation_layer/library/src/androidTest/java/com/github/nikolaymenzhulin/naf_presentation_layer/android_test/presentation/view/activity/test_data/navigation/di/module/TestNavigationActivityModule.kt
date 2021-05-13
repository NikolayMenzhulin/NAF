package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.TestNavigationActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.navigation.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class TestNavigationActivityModule(activity: TestNavigationActivity) : ActivityModule(activity, R.id.nav_host_fragment) {

    @PerActivity
    @Provides
    fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
}