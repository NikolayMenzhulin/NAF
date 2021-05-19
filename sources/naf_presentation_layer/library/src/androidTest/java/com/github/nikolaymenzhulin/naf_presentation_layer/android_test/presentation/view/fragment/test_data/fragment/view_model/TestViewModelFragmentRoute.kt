package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.view_model

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

class TestViewModelFragmentRoute() : AbstractFragmentRoute<TestViewModelFragment>() {

    constructor(args: Bundle?) : this()

    override fun getFragment(): TestViewModelFragment = TestViewModelFragment()
}