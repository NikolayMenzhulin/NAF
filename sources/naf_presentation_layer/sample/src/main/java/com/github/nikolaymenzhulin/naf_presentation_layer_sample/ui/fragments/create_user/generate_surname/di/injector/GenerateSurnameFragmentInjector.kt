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
    private val view: GenerateSurnameFragment
) : AbstractViewInjector<GenerateSurnameFragment>(view) {

    override fun initComponent() {
        GenerateSurnameFragmentComponentHolder.initComponent(GenerateSurnameFragmentModule(view))
    }

    override fun getViewComponent(): ViewComponent<GenerateSurnameFragment> =
        GenerateSurnameFragmentComponentHolder.component

    override fun clearComponent() {
        GenerateSurnameFragmentComponentHolder.clearComponent()
    }
}