package com.github.nikolaymenzhulin.naf_presentation_layer.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule

/**
 * Базовый класс контейнера для Dagger-компонента.
 *
 * @property component компонент, хранящийся в контейнере
 */
abstract class AbstractComponentHolder<C : DaggerComponent, M : DaggerModule> {

    val component: C
        get() = _component ?: throw IllegalStateException("The component isn't initialized")

    private var _component: C? = null

    /**
     * Инициализировать [component].
     *
     * @param module Dagger-модуль, который будет использоваться при создании [component]
     */
    fun initComponent(module: M) {
        _component = getComponentImpl(module)
    }

    /**
     * Очистить [component], хранящийся в контейнере.
     */
    fun clearComponent() {
        _component = null
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