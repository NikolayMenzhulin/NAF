package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.activity.test_data.view_binding.base

import android.content.Context
import android.content.Intent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractActivityRoute

class TestViewBindingActivityRoute() : AbstractActivityRoute() {

    constructor(intent: Intent) : this()

    override fun getIntent(context: Context): Intent = Intent(context, TestViewBindingActivity::class.java)
}