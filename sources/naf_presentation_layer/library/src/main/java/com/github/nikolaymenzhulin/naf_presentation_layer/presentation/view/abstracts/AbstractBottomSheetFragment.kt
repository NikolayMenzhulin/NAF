package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.lifecycle_wrapper.LifecycleWrapperBottomSheetFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base class for implementing a bottom sheet dialog fragment with support for
 * dependency injection, working with the view model, view binding.
 *
 * @param contentLayoutId the id of the layout for the bottom sheet dialog fragment
 * @param vbClass the class of the view binding associated with the bottom sheet dialog fragment
 */
abstract class AbstractBottomSheetFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperBottomSheetFragment<VM, VB>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}