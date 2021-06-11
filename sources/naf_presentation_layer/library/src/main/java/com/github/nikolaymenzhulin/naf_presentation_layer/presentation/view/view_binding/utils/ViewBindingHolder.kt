package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * The holder class for the view binding.
 *
 * @param vbClass the class of the view binding that contains inside a holder
 *
 * @property vb the view binding that contains inside a holder
 */
@Suppress("UNCHECKED_CAST")
internal class ViewBindingHolder<VB : ViewBinding>(private val vbClass: Class<VB>) {

    var vb: VB? = null
        private set

    /**
     * Initialize the [vb] using inflate method.
     */
    fun initViewBinding(layoutInflater: LayoutInflater) {
        if (vb != null) return
        val inflate = vbClass.getMethod("inflate", LayoutInflater::class.java)
        vb = inflate.invoke(null, layoutInflater) as VB
    }

    /**
     * Initialize the [vb] using inflate method.
     */
    fun initViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup? = null, attachToParent: Boolean) {
        if (vb != null) return
        val inflate = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        vb = inflate.invoke(null, layoutInflater, parent, attachToParent) as VB
    }

    /**
     * Initialize the [vb] using inflate bind.
     */
    fun initViewBinding(view: View) {
        if (vb != null) return
        val bind = vbClass.getMethod("bind", View::class.java)
        vb = bind.invoke(null, view) as VB
    }

    /**
     * Clear the [vb] that contains inside a holder.
     */
    fun clearViewBinding() {
        vb = null
    }
}