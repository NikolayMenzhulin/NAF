package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовый интерфейс для класса - инжектора зависимостей во view.
 */
interface ViewInjector<V : InjectableView, M : DaggerModule> : Injector {

    /**
     * Инициализировать Dagger-компонент для view.
     *
     * @param module Dagger-модуль, который будет использоваться при создании компонента
     */
    fun initComponent(module: M)

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