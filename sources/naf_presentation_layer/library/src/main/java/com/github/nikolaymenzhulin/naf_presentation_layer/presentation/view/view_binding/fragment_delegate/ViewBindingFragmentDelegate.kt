package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.fragment_delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingHolder

/**
 * Делегат, инкапсулирующий общую логику всех view binding fragment'ов.
 */
internal class ViewBindingFragmentDelegate<VB : ViewBinding>(
    @LayoutRes private val contentLayoutId: Int,
    vbClass: Class<VB>
) {

    internal val vbHolder: ViewBindingHolder<VB> = ViewBindingHolder(vbClass)

    private val vbCreateMethodType: ViewBindingCreateMethodType = if (contentLayoutId == 0) INFLATE else BIND

    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?): View? =
        if (vbCreateMethodType == INFLATE) {
            vbHolder.initViewBinding(inflater, container, false)
            vbHolder.vb!!.root
        } else {
            inflater.inflate(contentLayoutId, container, false)
        }

    fun onViewCreated(view: View) {
        if (vbCreateMethodType == BIND) vbHolder.initViewBinding(view)
    }

    fun onDestroyView() {
        vbHolder.clearViewBinding()
    }
}