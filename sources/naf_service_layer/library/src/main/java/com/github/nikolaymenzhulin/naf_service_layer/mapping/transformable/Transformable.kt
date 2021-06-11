package com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable

/**
 * The base interface for a class that implements the ability to transform it into another type.
 */
interface Transformable<out T>

/**
 * The interface for a class that implements its simple transformation (without input parameters) to another type.
 */
interface SimpleTransformable<out T> : Transformable<T> {

    /**
     * The transformation method.
     *
     * @return transformed object
     */
    fun transform(): T
}

/**
 * The interface for a class that implements its transformation,
 * for the successful implementation of which an input parameter is required.
 */
interface DependentTransformable<out T, in D> : Transformable<T> {

    /**
     * The transformation method.
     *
     * @param dependency dependency required to implement transformation
     *
     * @return transformed object
     */
    fun transform(dependency: D): T
}