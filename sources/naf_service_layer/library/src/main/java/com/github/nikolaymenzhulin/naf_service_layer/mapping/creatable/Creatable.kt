package com.github.nikolaymenzhulin.naf_service_layer.mapping.creatable

/**
 * Базовый интерфейс для класса, реализующего возможность создания одного класса на основе другого.
 */
interface Creatable<in From, out To>

/**
 * Интерфейс для класса, реализующего простое создание (без входных параметров) одного класса на основе другого.
 */
interface SimpleCreatable<in From, out To> : Creatable<From, To> {

    /**
     * Метод создания.
     *
     * @param from класс, на основе которого будет создан другой класс
     *
     * @return созданный на основе [from] новый класс
     */
    fun create(from: From): To
}

/**
 * Интерфейс для класса, реализующего создание одного класса на основе другого,
 * для успешного проведения которого необходим какой-либо входной параметр.
 */
interface DependentCreatable<in From, out To, in D> : Creatable<From, To> {

    /**
     * Метод создания.
     *
     * @param from класс, на основе которого будет создан другой класс
     * @param dependency зависимость, необходимая для осуществления создания
     *
     * @return созданный на основе [from] новый класс
     */
    fun create(from: From, dependency: D): To
}