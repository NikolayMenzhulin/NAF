package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.BIND
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingCreateMethodType.INFLATE
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding.utils.ViewBindingHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.ViewModelActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel

/**
 * The base activity with support for working with a view binding.
 *
 * @param contentLayoutId the id of the layout for the activity
 * @param vbClass the class of the view binding associated with the activity
 *
 * @property vb the view binding associated with the activity
 * @property vbCreateMethodType the creation type of the view binding
 */
abstract class ViewBindingActivity<VM : BaseViewModel, VB : ViewBinding>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : ViewModelActivity<VM>(contentLayoutId) {

    protected val vb: VB
        get() = vbHolder.vb
            ?: throw IllegalStateException("The view binding has not been initialized yet")

    private var vbHolder: ViewBindingHolder<VB> = ViewBindingHolder(vbClass)

    private val vbCreateMethodType: ViewBindingCreateMethodType = if (contentLayoutId == 0) INFLATE else BIND

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initViewBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        vbHolder.clearViewBinding()
    }

    private fun initViewBinding() {
        if (vbCreateMethodType == INFLATE) {
            vbHolder.initViewBinding(layoutInflater)
            setContentView(vb.root)
        } else {
            val rootView: View = findViewById<ViewGroup?>(android.R.id.content).run { getChildAt(0) }
            vbHolder.initViewBinding(rootView)
        }
    }
}