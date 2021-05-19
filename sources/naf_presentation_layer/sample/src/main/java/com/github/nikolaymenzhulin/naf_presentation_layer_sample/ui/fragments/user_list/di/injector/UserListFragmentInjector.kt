package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.holder.UserListFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.module.UserListFragmentModule

/**
 * Injector for [UserListFragment].
 */
class UserListFragmentInjector(
    view: UserListFragment,
    module: UserListFragmentModule = UserListFragmentModule(view)
) : AbstractViewInjector<UserListFragment, UserListFragmentModule>(view, module) {

    override fun initComponent(module: UserListFragmentModule) {
        UserListFragmentComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<UserListFragment> =
        UserListFragmentComponentHolder.component

    override fun clearComponent() {
        UserListFragmentComponentHolder.clearComponent()
    }
}