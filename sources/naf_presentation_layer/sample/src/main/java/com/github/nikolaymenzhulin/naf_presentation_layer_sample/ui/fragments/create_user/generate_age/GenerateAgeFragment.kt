package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.base.BaseGenerateUserFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.di.injector.GenerateAgeFragmentInjector

/**
 * The screen that generates an age for the user being created.
 */
class GenerateAgeFragment : BaseGenerateUserFragment<GenerateAgeFragmentViewModel, GenerateAgeFragmentNavigator>() {

    override val toolbarTitleResId: Int = R.string.generate_age_toolbar_title

    override val userDataTvTextResId: Int = R.string.generate_age_age_placeholder_text

    override val nextStepBtnTextResId: Int = R.string.generate_age_next_btn_text

    override val vm: GenerateAgeFragmentViewModel by viewModels()

    override val injector = GenerateAgeFragmentInjector(this)

    override fun initListeners() {
        super.initListeners()
        vb.generateUserDataBtn.setOnClickListener { vm.generateUserAge() }
        vb.nextStepBtn.setOnClickListener { navigator.backToUserListScreen() }
    }

    override fun onObserveViewModelData() {
        vm.userAge.observe(this, ::setUserData)
    }
}