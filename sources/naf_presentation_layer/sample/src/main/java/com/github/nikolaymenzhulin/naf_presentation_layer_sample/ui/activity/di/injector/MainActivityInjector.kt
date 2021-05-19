package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.MainActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.MainActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.MainActivityModule

/**
 * Injector for [MainActivity].
 */
class MainActivityInjector(
    view: MainActivity,
    module: MainActivityModule = MainActivityModule(view)
) : AbstractViewInjector<MainActivity, MainActivityModule>(view, module) {

    override fun initComponent(module: MainActivityModule) {
        MainActivityComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<MainActivity> =
        MainActivityComponentHolder.component

    override fun clearComponent() {
        MainActivityComponentHolder.clearComponent()
    }
}