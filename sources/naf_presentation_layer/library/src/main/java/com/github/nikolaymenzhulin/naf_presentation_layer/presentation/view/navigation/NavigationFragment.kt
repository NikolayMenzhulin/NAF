package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator

/**
 * The base fragment with Cicerone navigation support.
 *
 * @param contentLayoutId the id of the layout for the fragment
 * @param vbClass the class of the view binding associated with the fragment
 *
 * @property navigator the navigator that the parent activity is using
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