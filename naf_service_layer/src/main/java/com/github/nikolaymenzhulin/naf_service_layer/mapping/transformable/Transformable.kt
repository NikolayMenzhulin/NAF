package com.github.nikolaymenzhulin.naf_service_layer.mapping.transformable

/**
 * Базовый интерфейс для класса, реализующего возможность его трансформации в другой тип.
 */
interface Transformable<out T>

/**
 * Интерфейс для класса, реализующего его простую трансформацию (без входных параметров) в другой тип.
 */
interface SimpleTransformable<out T> : Transformable<T> {

    /**
     * Метод трансформации.
     *
     * @return трансформированный объект
     */
    fun transform(): T
}

/**
 * Интерфейс для класса, реализующего его трансформацию,
 * для успешного проведения которой необходим какой-либо входной параметр.
 */
interface DependentTransformable<out T, in D> : Transformable<T> {

    /**
     * Метод трансформации.
     *
     * @param dependency зависимость, необходимая для осуществления трансформации
     *
     * @return трансформированный объект
     */
    fun transform(dependency: D): T
}