package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовый интерфейс для класса - инжектора зависимостей во view.
 */
internal interface ViewInjector<V : InjectableView> : Injector {

    /**
     * Инициализировать Dagger-компонент для view.
     */
    fun initComponent()

    /**
     * Получить Dagger-компонент для view, который будет использоваться для инъекции зависимостей.
     *
     * @return компонент для view
     */
    fun getViewComponent(): ViewComponent<V>

    /**
     * Очистить Dagger-компонент для view.
     */
    fun clearComponent()
}