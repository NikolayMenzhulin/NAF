package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base

/**
 * Базовый интерфейс для класса - инжектора зависимостей.
 */
interface Injector {

    /**
     * Произвести инъекцию зависимостей.
     */
    fun inject()
}