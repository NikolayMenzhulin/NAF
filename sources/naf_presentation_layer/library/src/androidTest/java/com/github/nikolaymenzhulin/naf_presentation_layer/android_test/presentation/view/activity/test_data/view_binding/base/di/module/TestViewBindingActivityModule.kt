package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.TestViewBindingActivityRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import dagger.Module

@Module(includes = [ViewModelFactoryModule::class])
class TestViewBindingActivityModule(view: TestViewBindingActivity) :
    ActivityModule<TestViewBindingActivityRoute>(TestViewBindingActivityRoute(view.intent))