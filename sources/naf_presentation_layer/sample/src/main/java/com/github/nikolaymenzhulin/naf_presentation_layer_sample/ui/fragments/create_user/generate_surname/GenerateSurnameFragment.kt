package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.base.BaseGenerateUserFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_surname.di.injector.GenerateSurnameFragmentInjector

/**
 * The screen that generates a surname for the user being created.
 */
class GenerateSurnameFragment : BaseGenerateUserFragment<GenerateSurnameFragmentViewModel>() {

    override val toolbarTitleResId: Int = R.string.generate_surname_toolbar_title

    override val userDataTvTextResId: Int = R.string.generate_surname_surname_placeholder_text

    override val nextStepBtnTextResId: Int = R.string.generate_surname_next_btn_text

    override val vm: GenerateSurnameFragmentViewModel by viewModels()

    override val injector = GenerateSurnameFragmentInjector(this)

    override fun initListeners() {
        vb.toolbar.root.setNavigationOnClickListener { vm.exit() }
        vb.generateUserDataBtn.setOnClickListener { vm.generateUserSurname() }
        vb.nextStepBtn.setOnClickListener { vm.goToGenerateAgeScreen() }
    }

    override fun onObserveViewModelCallback() {
        vm.userSurname.observe(this, ::setUserData)
    }
}