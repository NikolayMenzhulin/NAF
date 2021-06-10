package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.host_activity

import android.content.Context
import android.content.Intent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractActivityRoute

class TestFragmentHostActivityRoute() : AbstractActivityRoute() {

    constructor(intent: Intent) : this()

    override fun getIntent(context: Context): Intent = Intent(context, TestFragmentHostActivity::class.java)
}