package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route

import androidx.fragment.app.DialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.DialogScreen
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.base.Route

/**
 * Базовый класс route для диалога, основанного на dialog fragment или bottom sheet fragment.
 */
abstract class AbstractDialogFragmentRoute<D : DialogFragment> : Route {

    /**
     * Создать dialog fragment/bottom sheet fragment для открываемого диалога.
     *
     * @return dialog fragment/bottom sheet fragment для открываемого диалога.
     */
    protected abstract fun getDialog(): D

    /**
     * Создать [DialogScreen] для открываемого диалога.
     *
     * @param key ключ, идентифицирующий открываемый диалог
     *
     * @return [DialogScreen] для открываемого диалога
     */
    operator fun invoke(key: String = this::class.java.name): DialogScreen =
        DialogScreen(key) { getDialog() }
}