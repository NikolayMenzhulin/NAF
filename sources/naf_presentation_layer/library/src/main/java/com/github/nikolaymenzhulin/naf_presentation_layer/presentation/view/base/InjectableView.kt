package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base

import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector

/**
 * Базовый интерфейс для view с поддержкой инъекции зависимостей.
 *
 * @property injector инжектор для инъекции зависимостей во view
 */
interface InjectableView {

    val injector: AbstractViewInjector<*>
}