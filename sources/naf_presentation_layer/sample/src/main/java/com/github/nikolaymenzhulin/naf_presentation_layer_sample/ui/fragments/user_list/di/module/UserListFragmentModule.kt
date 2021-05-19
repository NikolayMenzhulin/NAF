package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.component.UserListFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.navigator.NavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [UserListFragmentComponent].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class UserListFragmentModule(fragment: UserListFragment) : FragmentModule(fragment)