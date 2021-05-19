package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.base.BaseGenerateUserFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.di.injector.GenerateNameFragmentInjector

/**
 * The screen that generates a name for the user being created.
 */
class GenerateNameFragment : BaseGenerateUserFragment<GenerateNameFragmentViewModel, GenerateNameFragmentNavigator>() {

    override val toolbarTitleResId: Int = R.string.generate_name_toolbar_title

    override val userDataTvTextResId: Int = R.string.generate_name_name_placeholder_text

    override val nextStepBtnTextResId: Int = R.string.generate_name_next_btn_text

    override val vm: GenerateNameFragmentViewModel by viewModels()

    override val injector = GenerateNameFragmentInjector(this)

    override fun initListeners() {
        super.initListeners()
        vb.generateUserDataBtn.setOnClickListener { vm.generateUserName() }
        vb.nextStepBtn.setOnClickListener { navigator.goToGenerateSurnameScreen() }
    }

    override fun onObserveViewModelData() {
        vm.userName.observe(this, ::setUserData)
    }
}