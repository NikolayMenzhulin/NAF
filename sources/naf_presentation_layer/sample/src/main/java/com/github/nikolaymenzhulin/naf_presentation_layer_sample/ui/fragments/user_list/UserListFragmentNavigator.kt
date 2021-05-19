package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.util.constants.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * Navigator for [UserListFragment].
 */
class UserListFragmentNavigator @AssistedInject constructor(
    @Assisted override val vm: UserListFragmentViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<UserListFragmentViewModel>(commonDeps) {

    init {
        observeCreateUserFlowResult()
    }

    fun goToCreateUserFlow() {
        navController.navigate(R.id.action_userListFragment_to_createUserFlow)
    }

    private fun observeCreateUserFlowResult() {
        getNavigationResultFlow<UserDM>(EXTRA_FIRST)?.let { createUserFlowResult ->
            vm.setCreateUserFlowResult(createUserFlowResult)
        }
    }
}

@AssistedFactory
interface UserListFragmentNavigatorFactory : NavigatorAssistedFactory<UserListFragmentNavigator, UserListFragmentViewModel>