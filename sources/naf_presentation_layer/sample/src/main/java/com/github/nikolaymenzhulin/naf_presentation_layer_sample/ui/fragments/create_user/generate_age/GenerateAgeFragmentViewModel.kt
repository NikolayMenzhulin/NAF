package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age

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
 * ViewModel for [GenerateAgeFragment].
 */
class GenerateAgeFragmentViewModel @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: GenerateAgeFragmentNavDelegate,
    private val userGenerator: UserGenerator
) : AbstractViewModel<GenerateAgeFragmentNavDelegate>() {

    private var userBuilder: UserDM.Builder = navDelegate.route.userBuilder

    private val _userAge: MutableStateFlow<String> = MutableStateFlow("")
    val userAge: StateFlow<String> = _userAge.asStateFlow()

    fun generateUserAge() {
        val userAge: Int = userGenerator.generateAge()
        userBuilder.age = userAge
        _userAge.tryEmit(userAge.toString())
    }

    fun backToUserListScreen() {
        navDelegate.setCreateUserFlowResult(userBuilder.build())
    }

    fun exit() {
        navDelegate.exit()
    }
}

@AssistedFactory
interface GenerateAgeFragmentViewModelFactory : ViewModelAssistedFactory<GenerateAgeFragmentViewModel>