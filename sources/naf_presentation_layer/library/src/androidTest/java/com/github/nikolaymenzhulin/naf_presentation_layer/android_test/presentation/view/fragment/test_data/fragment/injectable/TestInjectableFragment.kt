package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.injector.TestInjectableFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.InjectableFragment
import javax.inject.Inject

class TestInjectableFragment : InjectableFragment() {

    @Inject
    lateinit var dependency: String

    override val injector = TestInjectableFragmentInjector(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_injectable_test, container, false)
}