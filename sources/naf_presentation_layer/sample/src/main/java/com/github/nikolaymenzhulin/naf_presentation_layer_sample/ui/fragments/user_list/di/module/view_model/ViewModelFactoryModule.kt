package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragmentViewModelFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.UserListFragmentModule
import dagger.Module

/**
 * Submodule of [UserListFragmentModule].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<UserListFragmentViewModelFactory>