package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

@PerActivity
class TestViewBindingActivityNavDelegate @Inject constructor(
    override val router: Router,
    override val route: TestViewBindingActivityRoute
) : AbstractNavDelegate<Router, TestViewBindingActivityRoute>()