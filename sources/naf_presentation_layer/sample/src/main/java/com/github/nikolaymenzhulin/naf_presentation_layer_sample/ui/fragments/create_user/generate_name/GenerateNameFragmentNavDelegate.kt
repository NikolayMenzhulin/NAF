package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.GenerateSurnameFragmentRoute
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [GenerateNameFragment].
 */
@PerFragment
class GenerateNameFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: GenerateNameFragmentRoute
) : AbstractNavDelegate<Router, GenerateNameFragmentRoute>() {

    fun goToGenerateSurnameScreen(userBuilder: UserDM.Builder) {
        router.navigateTo(GenerateSurnameFragmentRoute(userBuilder)())
    }
}