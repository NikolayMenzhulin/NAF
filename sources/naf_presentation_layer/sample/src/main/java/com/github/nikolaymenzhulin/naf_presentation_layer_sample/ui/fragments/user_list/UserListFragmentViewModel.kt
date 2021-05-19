package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for [UserListFragment].
 */
class UserListFragmentViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: UserListFragmentNavDelegate
) : AbstractViewModel<UserListFragmentNavDelegate>() {

    private val _userList: MutableStateFlow<MutableList<UserDM>> = MutableStateFlow(mutableListOf())
    val userList: StateFlow<List<UserDM>> = _userList.asStateFlow()

    fun goToCreateUserFlow() {
        observeCreateUserFlowResult()
        navDelegate.goToCreateUserFlow()
    }

    private fun observeCreateUserFlowResult() {
        launch(CoroutineName("ObserveCreateUserFlowResult")) {
            val createdUser: UserDM = navDelegate.getCreateUserFlowResult()
            _userList.value.add(createdUser)
        }
    }
}

@AssistedFactory
interface UserListFragmentViewModelFactory : ViewModelAssistedFactory<UserListFragmentViewModel>