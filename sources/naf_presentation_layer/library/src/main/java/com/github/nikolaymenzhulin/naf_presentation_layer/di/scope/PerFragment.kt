package com.github.nikolaymenzhulin.naf_presentation_layer.di.scope

import javax.inject.Scope

/**
 * The Dagger scope for entities whose lifecycle is equal to the lifecycle of the fragment in which they are used.
 */
@Scope
annotation class PerFragment