package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

/**
 * Базовый fragment с поддержкой навигации.
 *
 * @property navigatorHolder контейнер, содержащий используемый navigator
 * @property navigator навигатор, который использует fragment
 */
abstract class NavigationFragment<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingFragment<VM, VB>(contentLayoutId, vbClass) {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected val navigator: N
        get() = _navigator ?: throw IllegalStateException("The navigator has not been initialized yet")

    private var _navigator: N? = null

    @Suppress("DEPRECATION")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _navigator = createNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        _navigator = null
    }

    /**
     * Создать навигатор, который будет использовать fragment.
     *
     * @return навигатор для fragment
     */
    protected abstract fun createNavigator(): N
}