package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.fragment.app.Fragment
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.FragmentScreen
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route

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
     * @param enterAnimResId анимация fragment'а на который переходим
     * @param exitAnimResId анимация fragment'а с которого переходим
     * @param popEnterAnimResId анимация fragment'а на который возвращаемся
     * @param popExitAnimResId анимация fragment'а с которого возвращаемся
     *
     * @return [FragmentScreen] для открываемого экрана
     */
    operator fun invoke(
        key: String = this::class.java.name,
        clearContainer: Boolean = true,
        @AnimatorRes @AnimRes enterAnimResId: Int? = R.anim.base_enter,
        @AnimatorRes @AnimRes exitAnimResId: Int? = R.anim.base_exit,
        @AnimatorRes @AnimRes popEnterAnimResId: Int? = R.anim.base_pop_enter,
        @AnimatorRes @AnimRes popExitAnimResId: Int? = R.anim.base_pop_exit,
    ): FragmentScreen =
        FragmentScreen(
            key,
            clearContainer,
            enterAnimResId,
            exitAnimResId,
            popEnterAnimResId,
            popExitAnimResId
        ) { getFragment() }
}