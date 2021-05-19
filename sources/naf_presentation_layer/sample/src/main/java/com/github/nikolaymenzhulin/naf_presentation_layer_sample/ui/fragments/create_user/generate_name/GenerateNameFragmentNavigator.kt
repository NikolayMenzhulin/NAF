package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.util.constants.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.io.Serializable

/**
 * Navigator for [GenerateNameFragment].
 */
class GenerateNameFragmentNavigator @AssistedInject constructor(
    @Assisted override val vm: GenerateNameFragmentViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<GenerateNameFragmentViewModel>(commonDeps) {

    fun goToGenerateSurnameScreen() {
        val args = Bundle().apply {
            val userBuilder: Serializable = vm.userBuilder
            putSerializable(EXTRA_FIRST, userBuilder)
        }
        navController.navigate(R.id.action_generateNameFragment_to_generateSurnameFragment, args)
    }
}

@AssistedFactory
interface GenerateNameFragmentNavigatorFactory :
    NavigatorAssistedFactory<GenerateNameFragmentNavigator, GenerateNameFragmentViewModel>