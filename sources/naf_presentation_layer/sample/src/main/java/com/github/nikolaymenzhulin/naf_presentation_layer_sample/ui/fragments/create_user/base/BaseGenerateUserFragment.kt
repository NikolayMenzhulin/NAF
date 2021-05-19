package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.core.content.ContextCompat
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.FragmentGenerateUserBinding

abstract class BaseGenerateUserFragment<VM : BaseViewModel, N : AbstractNavigator<VM>> :
    AbstractFragment<VM, FragmentGenerateUserBinding, N>(
        FragmentGenerateUserBinding::class.java
    ) {

    protected abstract val toolbarTitleResId: Int
    protected abstract val userDataTvTextResId: Int
    protected abstract val nextStepBtnTextResId: Int

    @CallSuper
    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initViews()
        initListeners()
    }

    protected fun setUserData(data: String) {
        vb.nextStepBtn.isEnabled = data.isNotEmpty()
        if (data.isNotEmpty()) {
            vb.userDataTv.apply {
                text = data
                setTextColor(ContextCompat.getColor(context, android.R.color.black))
            }
        }
    }

    @CallSuper
    protected open fun initListeners() {
        vb.toolbar.root.setNavigationOnClickListener { navigator.finish() }
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