package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

@PerFragment
class TestViewModelFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: TestViewModelFragmentRoute
) : AbstractNavDelegate<Router, TestViewModelFragmentRoute>()