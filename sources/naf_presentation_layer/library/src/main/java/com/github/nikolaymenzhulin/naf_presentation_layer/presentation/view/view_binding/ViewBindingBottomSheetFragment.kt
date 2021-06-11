package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.fragment_delegate.ViewBindingFragmentDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelBottomSheetFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base bottom sheet dialog fragment with support for working with a view binding.
 *
 * @param contentLayoutId the id of the layout for the bottom sheet dialog fragment
 * @param vbClass the class of the view binding associated with the bottom sheet dialog fragment
 *
 * @property vb the view binding associated with the bottom sheet dialog fragment
 */
abstract class ViewBindingBottomSheetFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelBottomSheetFragment<VM>() {

    protected val vb: VB
        get() = delegate.vbHolder.vb
            ?: throw IllegalStateException("The view binding available only when a view of a bottom sheet dialog fragment is inflated")

    private val delegate by lazy { ViewBindingFragmentDelegate<VB>(contentLayoutId, vbClass) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        delegate.onCreateView(inflater, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        delegate.onViewCreated(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        delegate.onDestroyView()
    }
}