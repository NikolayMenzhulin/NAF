package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.NavigationFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import javax.inject.Inject

/**
 * Базовая activity с поддержкой работы с navigator.
 *
 * @param contentLayoutId layout id вёрстки для activity
 * @param vbClass класс view binding, связанный с activity
 *
 * @property navigatorFactory фабрика для создания navigator
 * @property navigator navigator, связанный с activity
 */
abstract class NavigationActivity<VM : BaseViewModel, VB : ViewBinding, N : AbstractNavigator<VM>>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingActivity<VM, VB>(contentLayoutId, vbClass) {

    @Inject
    lateinit var navigatorFactory: NavigatorAssistedFactory<N, VM>

    protected val navigator: N
        get() = _navigator
            ?: throw IllegalStateException("An error occurred while creating Navigator instance")

    private var _navigator: N? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigator()
    }

    override fun onBackPressed() {
        onSetNavigationResultForFragments()
        onSetNavigationResult()
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyNavigator()
    }

    private fun initNavigator() {
        _navigator = navigatorFactory.create(vm)
    }

    private fun onSetNavigationResultForFragments() {
        supportFragmentManager.fragments.forEach { fragment ->
            if (fragment is NavHostFragment) {
                fragment.childFragmentManager.fragments.forEach { childFragment ->
                    if (childFragment is NavigationFragment<*, *, *>) {
                        childFragment.onSetNavigationResult()
                    }
                }
            }
        }
    }

    private fun onSetNavigationResult() {
        _navigator?.onSetNavigationResult()
    }

    private fun destroyNavigator() {
        _navigator = null
    }
}