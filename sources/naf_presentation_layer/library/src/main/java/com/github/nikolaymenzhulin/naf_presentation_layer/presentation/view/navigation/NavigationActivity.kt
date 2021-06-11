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
 * The base activity with Cicerone navigation support.
 *
 * @param contentLayoutId the id of the layout for the activity
 * @param vbClass the class of the view binding associated with the activity
 *
 * @property navigatorHolder the holder containing the navigator used
 * @property navigator the navigator that is using the activity
 */
abstract class NavigationActivity<VM : BaseViewModel, VB : ViewBinding, N : Navigator>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewBindingActivity<VM, VB>(contentLayoutId, vbClass) {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    val navigator: N
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
     * Create a navigator that will use the activity.
     *
     * @return the navigator for the activity
     */
    protected abstract fun createNavigator(): N
}