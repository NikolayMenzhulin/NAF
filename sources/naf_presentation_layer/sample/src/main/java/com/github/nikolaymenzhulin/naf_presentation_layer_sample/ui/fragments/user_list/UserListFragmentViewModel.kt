package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list

import androidx.lifecycle.viewModelScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.*

/**
 * ViewModel for [UserListFragment].
 */
class UserListFragmentViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps
) : AbstractViewModel(commonDeps) {

    private val _userList: MutableStateFlow<MutableList<UserDM>> = MutableStateFlow(mutableListOf())
    val userList: StateFlow<List<UserDM>> = _userList.asStateFlow()

    fun setCreateUserFlowResult(createUserFlowResult: SharedFlow<UserDM>) {
        createUserFlowResult
            .onEach { user -> _userList.value.add(user) }
            .launchIn(viewModelScope)
    }
}

@AssistedFactory
interface UserListFragmentViewModelFactory : ViewModelAssistedFactory<UserListFragmentViewModel>