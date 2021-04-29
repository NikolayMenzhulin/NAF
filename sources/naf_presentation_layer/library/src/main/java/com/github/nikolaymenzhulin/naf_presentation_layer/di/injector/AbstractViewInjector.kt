package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.holder.AbstractComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base.ViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовый класс инжектора зависимостей во view.
 *
 * @param view view для инъекции зависимостей
 * @param module Dagger-модуль, который использует компонент view, ответственный за инъекцию зависимостей
 */
abstract class AbstractViewInjector<V : InjectableView, M : DaggerModule>(
    private val view: V,
    private val module: M
) : ViewInjector<V, M>, AbstractComponentHolder<ViewComponent<V>, M>() {

    override fun getComponentImpl(module: M): ViewComponent<V> = getViewComponent(module)

    override fun inject() {
        initComponent(module)
        component!!.inject(view)
    }
}