package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.GenerateNameFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.holder.GenerateNameFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.module.GenerateNameFragmentModule

/**
 * Injector for [GenerateNameFragment].
 */
class GenerateNameFragmentInjector(
    view: GenerateNameFragment,
    module: GenerateNameFragmentModule = GenerateNameFragmentModule(view)
) : AbstractViewInjector<GenerateNameFragment, GenerateNameFragmentModule>(view, module) {

    override fun initComponent(module: GenerateNameFragmentModule) {
        GenerateNameFragmentComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<GenerateNameFragment> =
        GenerateNameFragmentComponentHolder.component

    override fun clearComponent() {
        GenerateNameFragmentComponentHolder.clearComponent()
    }
}