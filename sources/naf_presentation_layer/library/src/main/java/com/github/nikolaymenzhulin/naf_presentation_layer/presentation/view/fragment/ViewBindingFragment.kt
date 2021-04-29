package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingCreateMethodType
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingCreateMethodType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingCreateMethodType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel

/**
 * Базовый fragment с поддержкой работы с view binding.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 * @param vbClass класс view binding, связанный с fragment
 *
 * @property vb view binding, связанный с fragment
 * @property vbCreateMethodType тип создания view binding
 */
abstract class ViewBindingFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelFragment<VM>(contentLayoutId) {

    protected val vb: VB
        get() = vbHolder.vb
            ?: throw IllegalStateException("ViewBinding instance available only when a view of a fragment is inflated and available")

    private var vbHolder: ViewBindingHolder<VB> = ViewBindingHolder(vbClass)

    private val vbCreateMethodType: ViewBindingCreateMethodType = if (contentLayoutId == 0) INFLATE else BIND

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        if (vbCreateMethodType == INFLATE) {
            vbHolder.initViewBinding(inflater, container, false)
            vb.root
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (vbCreateMethodType == BIND) vbHolder.initViewBinding(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vbHolder.clearViewBinding()
    }
}