package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.navigator

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseNavigatorFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragmentNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragmentNavigatorFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragmentViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.UserListFragmentModule
import dagger.Module

/**
 * Submodule of [UserListFragmentModule].
 */
@Module
interface NavigatorFactoryModule :
    BaseNavigatorFactoryModule<UserListFragmentNavigatorFactory, UserListFragmentNavigator, UserListFragmentViewModel>