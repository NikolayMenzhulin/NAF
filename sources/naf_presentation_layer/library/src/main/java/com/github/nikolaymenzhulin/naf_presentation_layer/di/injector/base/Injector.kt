package com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.base

/**
 * The base interface for a dependency injector class.
 */
internal interface Injector {

    /**
     * Inject dependencies.
     */
    fun inject()
}