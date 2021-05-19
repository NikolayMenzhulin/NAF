package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname

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
 * ViewModel for [GenerateSurnameFragment].
 */
class GenerateSurnameFragmentViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps,
    private val userGenerator: UserGenerator
) : AbstractViewModel(commonDeps) {

    var userBuilder: UserDM.Builder? = null

    private val _userSurname: MutableStateFlow<String> = MutableStateFlow("")
    val userSurname: StateFlow<String> = _userSurname.asStateFlow()

    fun generateUserSurname() {
        userBuilder?.let { userBuilder ->
            val userSurname: String = userGenerator.generateSurname()
            userBuilder.surname = userSurname
            _userSurname.tryEmit(userSurname)
        }
    }
}

@AssistedFactory
interface GenerateSurnameFragmentViewModelFactory : ViewModelAssistedFactory<GenerateSurnameFragmentViewModel>