package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.ViewBindingActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

/**
 * Базовая activity с поддержкой навигации.
 *
 * @property navigatorHolder контейнер, содержащий используемый navigator
 * @property navigator навигатор, который использует activity
 */
abstract class NavigationActivity<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingActivity<VM, VB>(contentLayoutId, vbClass) {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected val navigator: N
        get() = _navigator ?: throw IllegalStateException("The navigator has not been initialized yet")

    private var _navigator: N? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _navigator = createNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        _navigator = createNavigator()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
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
     * Создать навигатор, который будет использовать activity.
     *
     * @return навигатор для activity
     */
    protected abstract fun createNavigator(): N
}