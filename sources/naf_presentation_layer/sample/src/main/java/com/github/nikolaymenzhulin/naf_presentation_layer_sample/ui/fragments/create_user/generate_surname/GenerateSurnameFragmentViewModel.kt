package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
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
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: GenerateSurnameFragmentNavDelegate,
    private val userGenerator: UserGenerator
) : AbstractViewModel<GenerateSurnameFragmentNavDelegate>() {

    private val userBuilder: UserDM.Builder = navDelegate.route.userBuilder

    private val _userSurname: MutableStateFlow<String> = MutableStateFlow("")
    val userSurname: StateFlow<String> = _userSurname.asStateFlow()

    fun generateUserSurname() {
        val userSurname: String = userGenerator.generateSurname()
        userBuilder.surname = userSurname
        _userSurname.tryEmit(userSurname)
    }

    fun goToGenerateAgeScreen() {
        navDelegate.goToGenerateAgeScreen(userBuilder)
    }

    fun exit() {
        navDelegate.exit()
    }
}

@AssistedFactory
interface GenerateSurnameFragmentViewModelFactory : ViewModelAssistedFactory<GenerateSurnameFragmentViewModel>