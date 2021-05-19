package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

@PerActivity
class TestFragmentHostActivityNavDelegate @Inject constructor(
    override val router: Router,
    override val route: TestFragmentHostActivityRoute
) : AbstractNavDelegate<Router, TestFragmentHostActivityRoute>() {

    fun <R : AbstractFragmentRoute<*>> openFragmentScreen(route: R) {
        router.replaceScreen(route())
    }
}