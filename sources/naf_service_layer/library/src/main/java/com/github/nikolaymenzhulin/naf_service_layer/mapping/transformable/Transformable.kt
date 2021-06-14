/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
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