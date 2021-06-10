package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.fragment_delegate.ViewBindingFragmentDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * Базовый fragment с поддержкой работы с view binding.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 * @param vbClass класс view binding, связанный с fragment
 *
 * @property vb view binding, связанный с fragment
 */
abstract class ViewBindingFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelFragment<VM>() {

    protected val vb: VB
        get() = delegate.vbHolder.vb
            ?: throw IllegalStateException("The view binding available only when a view of a fragment is inflated")

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