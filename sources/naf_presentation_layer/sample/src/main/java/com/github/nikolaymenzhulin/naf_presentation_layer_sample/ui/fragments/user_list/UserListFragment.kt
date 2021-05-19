package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.FragmentUserListBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.holder.CreateUserComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.di.module.CreateUserModule
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.di.injector.UserListFragmentInjector

/**
 * The screen with a list of created users.
 */
class UserListFragment : AbstractFragment<UserListFragmentViewModel, FragmentUserListBinding, UserListFragmentNavigator>(
    FragmentUserListBinding::class.java
) {

    override val vm: UserListFragmentViewModel by viewModels()

    override val injector = UserListFragmentInjector(this)

    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initToolbar()
    }

    override fun onObserveViewModelData() {
        vm.userList.observe(this) { users ->
            vb.userListTv.text =
                if (users.isEmpty()) {
                    getString(R.string.user_list_empty_list_text)
                } else {
                    users.joinToString(separator = "\n")
                }
        }
    }

    override fun onStartCallback() {
        CreateUserComponentHolder.clearComponent()
    }

    private fun initToolbar() {

        fun onMenuItemClick(): Boolean {
            CreateUserComponentHolder.initComponent(CreateUserModule())
            navigator.goToCreateUserFlow()
            return true
        }

        vb.toolbar.root.apply {
            setTitle(R.string.user_list_toolbar_title)
            inflateMenu(R.menu.menu_user_list)
            setOnMenuItemClickListener { onMenuItemClick() }
        }
    }
}