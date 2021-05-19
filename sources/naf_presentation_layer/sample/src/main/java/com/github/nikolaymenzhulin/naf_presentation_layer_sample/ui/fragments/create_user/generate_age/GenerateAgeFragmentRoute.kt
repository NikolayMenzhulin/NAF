package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import java.io.Serializable

/**
 * Route for [GenerateAgeFragment].
 */
class GenerateAgeFragmentRoute(
    val userBuilder: UserDM.Builder
) : AbstractFragmentRoute<GenerateAgeFragment>() {

    constructor(args: Bundle?) : this(
        args?.getSerializable(EXTRA_FIRST) as UserDM.Builder
    )

    override fun getFragment(): GenerateAgeFragment =
        GenerateAgeFragment().apply {
            val arguments = Bundle().apply {
                putSerializable(EXTRA_FIRST, userBuilder as Serializable)
            }
            setArguments(arguments)
        }
}