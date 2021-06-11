package com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable

/**
 * The base interface for a class that implements the ability to create one class based on another.
 */
interface Creatable<in From, out To>

/**
 * The interface for a class that implements simple creation (without input parameters) of one class based on another.
 */
interface SimpleCreatable<in From, out To> : Creatable<From, To> {

    /**
     * The creation method.
     *
     * @param from the class from which another class will be created
     *
     * @return a new class created based on [from]
     */
    fun create(from: From): To
}

/**
 * The interface for a class that implements the creation of one class based on another,
 * for the successful execution of which an input parameter is required.
 */
interface DependentCreatable<in From, out To, in D> : Creatable<From, To> {

    /**
     * The creation method.
     *
     * @param from the class from which another class will be created
     * @param dependency dependency required to implement creation
     *
     * @return a new class created based on [from]
     */
    fun create(from: From, dependency: D): To
}