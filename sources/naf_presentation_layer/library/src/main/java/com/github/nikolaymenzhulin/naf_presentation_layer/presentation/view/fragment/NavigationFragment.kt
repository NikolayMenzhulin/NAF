package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import javax.inject.Inject

/**
 * Базовый fragment с поддержкой работы с navigator.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 * @param vbClass класс view binding, связанный с fragment
 *
 * @property navigatorFactory фабрика для создания navigator
 * @property navigator navigator, связанный с fragment
 */
abstract class NavigationFragment<VM : BaseViewModel, VB : ViewBinding, N : AbstractNavigator<VM>>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingFragment<VM, VB>(contentLayoutId, vbClass) {

    @Inject
    lateinit var navigatorFactory: NavigatorAssistedFactory<N, VM>

    protected val navigator: N
        get() = _navigator
            ?: throw IllegalStateException("Navigator instance available only when a view of a fragment is inflated and available")

    private var _navigator: N? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigator()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        destroyNavigator()
    }

    fun onSetNavigationResult() {
        _navigator?.onSetNavigationResult()
    }

    private fun initNavigator() {
        _navigator = navigatorFactory.create(vm)
    }

    private fun destroyNavigator() {
        _navigator = null
    }
}