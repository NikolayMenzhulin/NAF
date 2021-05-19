package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.TestViewModelActivityRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_model.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import dagger.Module

@Module(includes = [ViewModelFactoryModule::class])
class TestViewModelActivityModule(view: TestViewModelActivity) :
    ActivityModule<TestViewModelActivityRoute>(TestViewModelActivityRoute(view.intent))