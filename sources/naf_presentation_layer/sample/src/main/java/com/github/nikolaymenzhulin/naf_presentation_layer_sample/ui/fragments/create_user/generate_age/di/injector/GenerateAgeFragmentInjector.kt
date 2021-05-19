package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.holder.GenerateAgeFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.module.GenerateAgeFragmentModule

/**
 * Injector for [GenerateAgeFragment].
 */
class GenerateAgeFragmentInjector(
    private val view: GenerateAgeFragment
) : AbstractViewInjector<GenerateAgeFragment>(view) {

    override fun initComponent() {
        GenerateAgeFragmentComponentHolder.initComponent(GenerateAgeFragmentModule(view))
    }

    override fun getViewComponent(): ViewComponent<GenerateAgeFragment> =
        GenerateAgeFragmentComponentHolder.component

    override fun clearComponent() {
        GenerateAgeFragmentComponentHolder.clearComponent()
    }
}