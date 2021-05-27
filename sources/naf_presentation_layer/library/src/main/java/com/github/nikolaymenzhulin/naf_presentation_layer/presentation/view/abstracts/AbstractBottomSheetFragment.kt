package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.lifecycle_wrapper.LifecycleWrapperBottomSheetFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * Базовый класс для реализации bottom sheet fragment с поддержкой инъекции зависимостей, работы с view model и view binding.
 *
 * @param contentLayoutId layout id вёрстки для bottom sheet fragment
 * @param vbClass класс view binding, связанный с bottom sheet fragment
 */
abstract class AbstractBottomSheetFragment<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperBottomSheetFragment<VM, VB>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}