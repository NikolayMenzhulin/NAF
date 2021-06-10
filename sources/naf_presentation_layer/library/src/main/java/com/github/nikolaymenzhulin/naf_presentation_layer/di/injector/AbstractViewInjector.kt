package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base.ViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовый класс инжектора зависимостей во view.
 *
 * @param view view для инъекции зависимостей
 */
abstract class AbstractViewInjector<V : InjectableView>(private val view: V) : ViewInjector<V> {

    override fun inject() {
        initComponent()
        getViewComponent().inject(view)
    }
}