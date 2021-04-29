package com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule

/**
 * Базовый класс контейнера для Dagger-компонента.
 *
 * @property component компонент, хранящийся в контейнере
 */
abstract class AbstractComponentHolder<C : DaggerComponent, M : DaggerModule> {

    var component: C? = null
        private set

    /**
     * Инициализировать [component], если он ещё не был инициализирован.
     *
     * @param module Dagger-модуль, который будет использоваться при создании [component]
     */
    fun initComponent(module: M) {
        if (component != null) return
        component = getComponentImpl(module)
    }

    /**
     * Очистить [component], хранящийся в контейнере.
     */
    fun clearComponent() {
        component = null
    }

    /**
     * Получить компонент для сохранения в контейнере.
     *
     * @param module Dagger-модуль, который будет использоваться при создании компонента
     *
     * @return компонент для сохранения в контейнере
     */
    protected abstract fun getComponentImpl(module: M): C
}