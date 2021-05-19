package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.GenerateSurnameFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.holder.GenerateSurnameFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.module.GenerateSurnameFragmentModule

/**
 * Injector for [GenerateSurnameFragment].
 */
class GenerateSurnameFragmentInjector(
    view: GenerateSurnameFragment,
    module: GenerateSurnameFragmentModule = GenerateSurnameFragmentModule(view)
) : AbstractViewInjector<GenerateSurnameFragment, GenerateSurnameFragmentModule>(view, module) {

    override fun initComponent(module: GenerateSurnameFragmentModule) {
        GenerateSurnameFragmentComponentHolder.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<GenerateSurnameFragment> =
        GenerateSurnameFragmentComponentHolder.component

    override fun clearComponent() {
        GenerateSurnameFragmentComponentHolder.clearComponent()
    }
}