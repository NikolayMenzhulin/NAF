package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity

import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator

/**
 * Базовый класс для реализации activity с поддержкой инъекции зависимостей, работы с view model, view binding и с навигацией.
 *
 * @param contentLayoutId layout id вёрстки для activity
 * @param vbClass класс view binding, связанный с activity
 */
abstract class AbstractActivity<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : LifecycleWrapperActivity<VM, VB, N>(contentLayoutId, vbClass) {

    constructor(vbClass: Class<VB>) : this(contentLayoutId = 0, vbClass = vbClass)
}