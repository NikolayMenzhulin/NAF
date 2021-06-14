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
package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * The base interface of the assisted factory providing the view model.
 */
interface ViewModelAssistedFactory<VM : ViewModel> {

    /**
     * Create a view model.
     *
     * @param savedStateHandle the [SavedStateHandle] associated with a view
     *
     * @return the created view model
     */
    fun create(savedStateHandle: SavedStateHandle): VM
}