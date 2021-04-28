package com.github.nikolaymenzhulin.naf_service_layer_sample.utils

import kotlin.random.Random

class UserNameGenerator {

    private val randomUserNames: List<String> = listOf("Patrick", "Oscar", "Garey", "Tyler", "Eileen", "Hubert", "Willis", "Luke")

    fun getUserName(): String = randomUserNames[Random.nextInt(0, randomUserNames.size - 1)]
}