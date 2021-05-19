package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.UserGenerator
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ViewModel for [GenerateNameFragment].
 */
class GenerateNameFragmentViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps,
    private val userGenerator: UserGenerator
) : AbstractViewModel(commonDeps) {

    val userBuilder: UserDM.Builder = UserDM.Builder()

    private val _userName: MutableStateFlow<String> = MutableStateFlow("")
    val userName: StateFlow<String> = _userName.asStateFlow()

    fun generateUserName() {
        val userName: String = userGenerator.generateName()
        userBuilder.name = userName
        _userName.tryEmit(userName)
    }
}

@AssistedFactory
interface GenerateNameFragmentViewModelFactory : ViewModelAssistedFactory<GenerateNameFragmentViewModel>