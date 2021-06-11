package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import com.github.terrakok.cicerone.androidx.ActivityScreen

/**
 * The base route class for the activity-based screen.
 */
abstract class AbstractActivityRoute : Route {

    /**
     * Create an activity intent for the screen to open.
     *
     * @return the activity intent for the screen to open
     */
    protected abstract fun getIntent(context: Context): Intent

    /**
     * Create an [ActivityScreen] for the screen to open.
     *
     * @param key key identifying the screen to open
     * @param startActivityOptions options for the screen to open
     *
     * @return the [ActivityScreen] for the screen to open
     */
    operator fun invoke(
        key: String = this::class.java.name,
        startActivityOptions: Bundle? = null
    ): ActivityScreen =
        ActivityScreen(key, startActivityOptions) { getIntent(it) }
}