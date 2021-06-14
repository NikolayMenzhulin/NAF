/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
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