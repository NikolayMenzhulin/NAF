package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator

/**
 * Базовый fragment с поддержкой навигации.
 *
 * @param contentLayoutId layout id вёрстки для activity
 * @param vbClass класс view binding, связанный с activity
 *
 * @property navigator навигатор, который использует родительская activity
 */
abstract class NavigationFragment<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingFragment<VM, VB>(contentLayoutId, vbClass) {

    @Suppress("UNCHECKED_CAST")
    protected val navigator: N
        get() = _navigator as? N ?: throw IllegalStateException("The navigator has not been initialized yet")

    private var _navigator: Navigator? = null

    override fun onActivityCreate() {
        super.onActivityCreate()
        _navigator = (requireActivity() as NavigationActivity<*, *, *>).navigator
    }

    override fun onDestroy() {
        super.onDestroy()
        _navigator = null
    }
}