package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.lifecycle_wrapper.LifecycleWrapperDialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base class for implementing a dialog fragment with support for
 * dependency injection, working with the view model, view binding.
 *
 * @param contentLayoutId the id of the layout for the dialog fragment
 * @param vbClass the class of the view binding associated with the dialog fragment
 */
abstract class AbstractDialogFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperDialogFragment<VM, VB>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}