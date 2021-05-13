package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.injector.TestInjectableFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.InjectableFragment
import javax.inject.Inject

class TestInjectableFragment : InjectableFragment(R.layout.fragment_injectable_test) {

    @Inject
    lateinit var dependency: String

    override val injector = TestInjectableFragmentInjector(this)
}