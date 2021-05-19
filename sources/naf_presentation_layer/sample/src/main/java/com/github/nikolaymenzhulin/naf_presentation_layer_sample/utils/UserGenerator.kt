package com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils

import kotlin.random.Random

class UserGenerator {

    private val randomNames = listOf(
        "Robert",
        "Rebecca",
        "Cassandra",
        "Stella",
        "Linda",
        "Jeremy",
        "Kenneth",
        "Patricia",
        "Paul",
        "Davis",
    )

    private val randomSurnames = listOf(
        "Bush",
        "Barton",
        "Smith",
        "Mann",
        "Hawkins",
        "Nelson",
        "Lopez",
        "Lucas",
        "Garza",
        "Davis",
    )

    fun generateName(): String = randomNames.getRandom()

    fun generateSurname(): String = randomSurnames.getRandom()

    fun generateAge(): Int = Random.nextInt(1, 100)

    private fun <T> List<T>.getRandom(): T {
        val randomIndex: Int = Random.nextInt(0, size - 1)
        return get(randomIndex)
    }
}