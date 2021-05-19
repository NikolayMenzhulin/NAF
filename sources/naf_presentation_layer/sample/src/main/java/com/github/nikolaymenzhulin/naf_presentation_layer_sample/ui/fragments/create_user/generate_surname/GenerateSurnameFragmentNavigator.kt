package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.util.constants.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.io.Serializable

/**
 * Navigator for [GenerateSurnameFragment].
 */
class GenerateSurnameFragmentNavigator @AssistedInject constructor(
    @Assisted override val vm: GenerateSurnameFragmentViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<GenerateSurnameFragmentViewModel>(commonDeps) {

    init {
        setUserBuilder()
    }

    fun goToGenerateAgeScreen() {
        val args = Bundle().apply {
            val userBuilder: Serializable = vm.userBuilder ?: return@apply
            putSerializable(EXTRA_FIRST, userBuilder)
        }
        navController.navigate(R.id.action_generateSurnameFragment_to_generateAgeFragment, args)
    }

    private fun setUserBuilder() {
        val userBuilder: UserDM.Builder? = arguments?.get(EXTRA_FIRST) as? UserDM.Builder
        userBuilder?.let(vm::userBuilder::set)
    }
}

@AssistedFactory
interface GenerateSurnameFragmentNavigatorFactory :
    NavigatorAssistedFactory<GenerateSurnameFragmentNavigator, GenerateSurnameFragmentViewModel>