package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.base.TestViewBindingFragmentRoute.ScreenType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.bind.TestBindViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_binding.inflate.TestInflateViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route.Companion.EXTRA_FIRST

class TestViewBindingFragmentRoute(private val screenType: ScreenType) : AbstractFragmentRoute<TestViewBindingFragment>() {

    constructor(args: Bundle?) : this(
        args?.getSerializable(EXTRA_FIRST) as ScreenType
    )

    enum class ScreenType {
        BIND, INFLATE
    }

    override fun getFragment(): TestViewBindingFragment {
        val fragment: TestViewBindingFragment =
            when (screenType) {
                BIND -> TestBindViewBindingFragment()
                INFLATE -> TestInflateViewBindingFragment()
            }
        return fragment.apply {
            val args = Bundle().apply {
                putSerializable(EXTRA_FIRST, screenType)
            }
            arguments = args
        }
    }
}