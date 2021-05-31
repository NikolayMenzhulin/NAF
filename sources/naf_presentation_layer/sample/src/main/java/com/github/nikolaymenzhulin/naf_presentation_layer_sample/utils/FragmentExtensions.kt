package com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment

fun Fragment.addOnBackPressedCallback(
    enabled: Boolean = true,
    onBackPressed: OnBackPressedCallback.() -> Unit
) {
    activity?.onBackPressedDispatcher?.addCallback(
        owner = this,
        enabled = enabled,
        onBackPressed = onBackPressed
    )
}