package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age

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
 * ViewModel for [GenerateAgeFragment].
 */
class GenerateAgeFragmentViewModel @AssistedInject constructor(
    @Assisted commonDeps: CommonViewModelDeps,
    private val userGenerator: UserGenerator
) : AbstractViewModel(commonDeps) {

    var userBuilder: UserDM.Builder? = null

    private val _userAge: MutableStateFlow<String> = MutableStateFlow("")
    val userAge: StateFlow<String> = _userAge.asStateFlow()

    fun generateUserAge() {
        userBuilder?.let { userBuilder ->
            val userAge: Int = userGenerator.generateAge()
            userBuilder.age = userAge
            _userAge.tryEmit(userAge.toString())
        }
    }
}

@AssistedFactory
interface GenerateAgeFragmentViewModelFactory : ViewModelAssistedFactory<GenerateAgeFragmentViewModel>