package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import com.github.terrakok.cicerone.androidx.ActivityScreen

/**
 * Базовый класс route для экрана, основанного на activity.
 */
abstract class AbstractActivityRoute : Route {

    /**
     * Создать activity intent для открываемого экрана.
     *
     * @return activity intent для открываемого экрана
     */
    protected abstract fun getIntent(context: Context): Intent

    /**
     * Создать [ActivityScreen] для открываемого экрана.
     *
     * @param key ключ, идентифицирующий открываемый экран
     * @param startActivityOptions параметры открываемого экрана
     *
     * @return [ActivityScreen] для открываемого экрана
     */
    operator fun invoke(
        key: String = this::class.java.name,
        startActivityOptions: Bundle? = null
    ): ActivityScreen =
        ActivityScreen(key, startActivityOptions) { getIntent(it) }
}