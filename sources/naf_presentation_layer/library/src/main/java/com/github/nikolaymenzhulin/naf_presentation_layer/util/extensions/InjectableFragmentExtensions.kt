package com.github.nikolaymenzhulin.naf_presentation_layer.util.extensions

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.InjectableActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.InjectableFragment

/**
 * Extension методы для [AbstractFragment].
 */

inline fun <reified A : InjectableActivity, reified C : DaggerComponent> InjectableFragment.getActivityComponent(): C =
    (requireActivity() as A).injector.component as C