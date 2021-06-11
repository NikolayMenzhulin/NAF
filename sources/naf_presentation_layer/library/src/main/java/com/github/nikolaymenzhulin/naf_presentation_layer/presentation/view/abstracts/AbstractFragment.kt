package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.lifecycle_wrapper.LifecycleWrapperFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator

/**
 * The base class for implementing a fragment with support for
 * dependency injection, working with the view model, view binding and Cicerone navigation.
 *
 * @param contentLayoutId the id of the layout for the fragment
 * @param vbClass the class of the view binding associated with the fragment
 */
abstract class AbstractFragment<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperFragment<VM, VB, N>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}