package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.TestViewModelFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.TestViewModelFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model.di.module.view_model.ViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import dagger.Module

@Module(includes = [ViewModelFactoryModule::class])
class TestViewModelFragmentModule(view: TestViewModelFragment) :
    FragmentModule<TestViewModelFragmentRoute>(TestViewModelFragmentRoute(view.arguments))