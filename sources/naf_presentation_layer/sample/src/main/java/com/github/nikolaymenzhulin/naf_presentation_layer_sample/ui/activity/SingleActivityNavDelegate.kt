package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [SingleActivity].
 */
@PerActivity
class SingleActivityNavDelegate @Inject constructor(
    override val router: Router,
    override val route: SingleActivityRoute
) : AbstractNavDelegate<Router, SingleActivityRoute>()