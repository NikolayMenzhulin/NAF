package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * Класс-контейнер для view binding.
 *
 * @param vbClass класс view binding, хранящегося в контейнере
 *
 * @property vb view binding, хранящийся в контейнере
 */
@Suppress("UNCHECKED_CAST")
internal class ViewBindingHolder<VB : ViewBinding>(private val vbClass: Class<VB>) {

    var vb: VB? = null
        private set

    /**
     * Инициализировать [vb] через метод inflate.
     */
    fun initViewBinding(layoutInflater: LayoutInflater) {
        if (vb != null) return
        val inflate = vbClass.getMethod("inflate", LayoutInflater::class.java)
        vb = inflate.invoke(null, layoutInflater) as VB
    }

    /**
     * Инициализировать [vb] через метод inflate.
     */
    fun initViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup? = null, attachToParent: Boolean) {
        if (vb != null) return
        val inflate = vbClass.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
        vb = inflate.invoke(null, layoutInflater, parent, attachToParent) as VB
    }

    /**
     * Инициализировать [vb] через метод bind.
     */
    fun initViewBinding(view: View) {
        if (vb != null) return
        val bind = vbClass.getMethod("bind", View::class.java)
        vb = bind.invoke(null, view) as VB
    }

    /**
     * Очистить [vb], хранящийся в контейнере.
     */
    fun clearViewBinding() {
        vb = null
    }
}