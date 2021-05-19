package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity

import android.content.Context
import android.content.Intent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractActivityRoute

/**
 * Route for [MainActivity].
 */
class MainActivityRoute() : AbstractActivityRoute() {

    constructor(intent: Intent) : this()

    override fun getIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
}