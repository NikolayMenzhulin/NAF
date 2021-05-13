package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.test_data.error_handler.TestErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.util.helpers.error_handler.base.ErrorHandler
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class TestFragmentHostActivityModule(activity: TestFragmentHostActivity) : ActivityModule(activity, R.id.nav_host_fragment) {

    @PerActivity
    @Provides
    fun provideErrorHandler(): ErrorHandler = TestErrorHandler()
}