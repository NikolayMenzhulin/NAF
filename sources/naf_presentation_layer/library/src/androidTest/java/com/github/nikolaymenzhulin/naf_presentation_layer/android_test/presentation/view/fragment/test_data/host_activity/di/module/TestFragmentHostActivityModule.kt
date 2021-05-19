package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.TestFragmentHostActivityRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import dagger.Module

@Module(includes = [ViewModelFactoryModule::class])
class TestFragmentHostActivityModule(view: TestFragmentHostActivity) :
    ActivityModule<TestFragmentHostActivityRoute>(TestFragmentHostActivityRoute(view.intent))