package com.github.nikolaymenzhulin.naf_presentation_layer.di.scope

import javax.inject.Scope

/**
 * Dagger-скоуп для сущностей, время жизни которых равно времени жизни dialog fragment или bottom sheet fragment, в котором они используются.
 */
@Scope
annotation class PerDialog