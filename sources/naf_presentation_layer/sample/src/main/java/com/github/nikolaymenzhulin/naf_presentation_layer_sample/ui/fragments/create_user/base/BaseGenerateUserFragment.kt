package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.core.content.ContextCompat
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.FragmentGenerateUserBinding
import com.github.terrakok.cicerone.androidx.AppNavigator

abstract class BaseGenerateUserFragment<VM : BaseViewModel> : AbstractFragment<VM, FragmentGenerateUserBinding, AppNavigator>(
    FragmentGenerateUserBinding::class.java
) {

    protected abstract val toolbarTitleResId: Int
    protected abstract val userDataTvTextResId: Int
    protected abstract val nextStepBtnTextResId: Int

    override fun createNavigator() = AppNavigator(requireActivity(), R.id.fragment_container)

    @CallSuper
    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initViews()
        initListeners()
    }

    protected abstract fun initListeners()

    protected fun setUserData(data: String) {
        vb.nextStepBtn.isEnabled = data.isNotEmpty()
        if (data.isNotEmpty()) {
            vb.userDataTv.apply {
                text = data
                setTextColor(ContextCompat.getColor(context, android.R.color.black))
            }
        }
    }

    private fun initViews() {
        vb.toolbar.root.apply {
            setTitle(toolbarTitleResId)
            setNavigationIcon(R.drawable.ic_arrow_left)
        }
        vb.userDataTv.apply {
            setText(userDataTvTextResId)
            setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        }
        vb.nextStepBtn.setText(nextStepBtnTextResId)
    }
}