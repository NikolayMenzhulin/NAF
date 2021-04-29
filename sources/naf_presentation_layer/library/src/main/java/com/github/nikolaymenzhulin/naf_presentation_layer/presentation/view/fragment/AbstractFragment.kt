package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel

/**
 * Базовый класс для реализации fragment с поддержкой инъекции зависимостей, а также работы с view model, view binding и navigator.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 * @param vbClass класс view binding, связанный с fragment
 */
abstract class AbstractFragment<VM : BaseViewModel, VB : ViewBinding, N : AbstractNavigator<VM>>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperFragment<VM, VB, N>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}