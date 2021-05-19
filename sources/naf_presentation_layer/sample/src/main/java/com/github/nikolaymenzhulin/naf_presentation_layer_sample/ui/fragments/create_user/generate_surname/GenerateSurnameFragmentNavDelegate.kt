package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragmentRoute
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [GenerateSurnameFragment].
 */
@PerFragment
class GenerateSurnameFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: GenerateSurnameFragmentRoute
) : AbstractNavDelegate<Router, GenerateSurnameFragmentRoute>() {

    fun goToGenerateAgeScreen(userBuilder: UserDM.Builder) {
        router.navigateTo(GenerateAgeFragmentRoute(userBuilder)())
    }
}