package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route

import androidx.fragment.app.Fragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Базовый класс route для экрана, основанного на fragment.
 */
abstract class AbstractFragmentRoute<F : Fragment> : Route {

    /**
     * Создать fragment для открываемого экрана.
     *
     * @return fragment для открываемого экрана.
     */
    protected abstract fun getFragment(): F

    /**
     * Создать [FragmentScreen] для открываемого экрана.
     *
     * @param key ключ, идентифицирующий открываемый экран
     * @param clearContainer заменять ли текущий открытый экран открываемым
     *
     * @return [FragmentScreen] для открываемого экрана
     */
    operator fun invoke(
        key: String = this::class.java.name,
        clearContainer: Boolean = true
    ): FragmentScreen =
        FragmentScreen(key, clearContainer) { getFragment() }
}