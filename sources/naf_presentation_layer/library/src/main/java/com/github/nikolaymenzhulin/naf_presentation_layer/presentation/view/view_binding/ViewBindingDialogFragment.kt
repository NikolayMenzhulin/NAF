package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.fragment_delegate.ViewBindingFragmentDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelDialogFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base dialog fragment with support for working with a view binding.
 *
 * @param contentLayoutId the id of the layout for the dialog fragment
 * @param vbClass the class of the view binding associated with the dialog fragment
 *
 * @property vb the view binding associated with the dialog fragment
 */
abstract class ViewBindingDialogFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelDialogFragment<VM>() {

    protected val vb: VB
        get() = delegate.vbHolder.vb
            ?: throw IllegalStateException("The view binding available only when a view of a dialog fragment is inflated")

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