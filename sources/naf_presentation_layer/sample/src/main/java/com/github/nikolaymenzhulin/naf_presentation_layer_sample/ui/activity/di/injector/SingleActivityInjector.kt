package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.SingleActivity
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.holder.SingleActivityComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.activity.di.module.SingleActivityModule

/**
 * Injector for [SingleActivity].
 */
class SingleActivityInjector(
    private val view: SingleActivity
) : AbstractViewInjector<SingleActivity>(view) {

    override fun initComponent() {
        SingleActivityComponentHolder.initComponent(SingleActivityModule(view))
    }

    override fun getViewComponent(): ViewComponent<SingleActivity> =
        SingleActivityComponentHolder.component

    override fun clearComponent() {
        SingleActivityComponentHolder.clearComponent()
    }
}