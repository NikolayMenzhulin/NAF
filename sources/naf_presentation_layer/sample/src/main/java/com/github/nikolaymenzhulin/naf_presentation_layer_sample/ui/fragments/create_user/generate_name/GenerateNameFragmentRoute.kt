package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

/**
 * Route for [GenerateNameFragment].
 */
class GenerateNameFragmentRoute() : AbstractFragmentRoute<GenerateNameFragment>() {

    constructor(args: Bundle?) : this()

    override fun getFragment(): GenerateNameFragment = GenerateNameFragment()
}