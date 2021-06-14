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