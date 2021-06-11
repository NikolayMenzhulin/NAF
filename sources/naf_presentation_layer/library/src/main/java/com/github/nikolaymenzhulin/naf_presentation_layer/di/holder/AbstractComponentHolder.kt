package com.github.nikolaymenzhulin.naf_presentation_layer.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.base.DaggerModule

/**
 * The base class for a holder of a Dagger component.
 *
 * @property component the component that contains inside a holder
 */
abstract class AbstractComponentHolder<C : DaggerComponent, M : DaggerModule> {

    val component: C
        get() = _component ?: throw IllegalStateException("The component isn't initialized")

    private var _component: C? = null

    /**
     * Initialize the [component].
     *
     * @param module the Dagger module to be used when creating the [component]
     */
    fun initComponent(module: M) {
        _component = getComponentImpl(module)
    }

    /**
     * Clear the [component] that contains inside a holder.
     */
    fun clearComponent() {
        _component = null
    }

    /**
     * Get a component for saving inside a holder.
     *
     * @param module the Dagger module to be used when creating the [component]
     *
     * @return the component for saving inside a holder
     */
    protected abstract fun getComponentImpl(module: M): C
}