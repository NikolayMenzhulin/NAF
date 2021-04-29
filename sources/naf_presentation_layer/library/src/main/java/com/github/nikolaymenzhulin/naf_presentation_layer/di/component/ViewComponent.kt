package com.github.nikolaymenzhulin.naf_presentation_layer.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовый интерфейс для Dagger-компонентов, предназначенных для инъекции зависимостей во view.
 */
interface ViewComponent<V : InjectableView> : DaggerComponent {

    /**
     * Произвести инъекцию зависимостей во view.
     *
     * @param view view для инъекции зависимостей
     */
    fun inject(view: V)
}