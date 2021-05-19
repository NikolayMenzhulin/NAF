package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import java.io.Serializable

/**
 * Route for [GenerateSurnameFragment].
 */
class GenerateSurnameFragmentRoute(
    val userBuilder: UserDM.Builder
) : AbstractFragmentRoute<GenerateSurnameFragment>() {

    constructor(args: Bundle?) : this(
        args?.getSerializable(EXTRA_FIRST) as UserDM.Builder
    )

    override fun getFragment(): GenerateSurnameFragment =
        GenerateSurnameFragment().apply {
            val arguments = Bundle().apply {
                putSerializable(EXTRA_FIRST, userBuilder as Serializable)
            }
            setArguments(arguments)
        }
}