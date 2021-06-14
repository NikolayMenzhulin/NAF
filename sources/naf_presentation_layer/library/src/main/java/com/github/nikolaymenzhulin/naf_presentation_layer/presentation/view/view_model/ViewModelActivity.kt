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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.InjectableActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.SavedStateViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * The base activity with support for working with a view model.
 *
 * @param contentLayoutId the id of the layout for the activity
 *
 * @property vmFactory the factory for creating the view model
 * @property vm the view model associated with the activity
 */
abstract class ViewModelActivity<VM : BaseViewModel>(
    @LayoutRes contentLayoutId: Int
) : InjectableActivity(contentLayoutId) {

    @Inject
    lateinit var vmFactory: ViewModelFactory.Factory

    protected abstract val vm: VM

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        vmFactory.create(this, intent.extras)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        (vm as? SavedStateViewModel)?.onSaveInstantState()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        (vm as? SavedStateViewModel)?.onSaveInstantState()
    }

    /**
     * Observe the data inside the [Flow].
     *
     * @param lifecycleOwner the lifecycle of a view to bind the subscription state to it
     * @param observer actions to perform when receiving data from the [Flow]
     */
    protected fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
        lifecycleOwner.lifecycleScope.launchWhenStarted {
            onEach(observer::invoke).collect()
        }
    }
}