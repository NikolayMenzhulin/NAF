package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable

import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.injectable.di.injector.TestInjectableActivityInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.InjectableActivity
import javax.inject.Inject

class TestInjectableActivity : InjectableActivity(R.layout.activity_injectable_test) {

    @Inject
    lateinit var dependency: String

    override val injector = TestInjectableActivityInjector(this)
}