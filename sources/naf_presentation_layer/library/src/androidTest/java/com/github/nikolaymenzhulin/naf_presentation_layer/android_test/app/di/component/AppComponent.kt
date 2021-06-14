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
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.component.deps_provider.AppDepsProvider
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.module.AppModule
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.scope.PerApp
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import dagger.Component

@PerApp
@Component(modules = [AppModule::class])
interface AppComponent : DaggerComponent, AppDepsProvider {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: AppModule): AppComponent =
            DaggerAppComponent.builder()
                .appModule(module)
                .build()
    }
}