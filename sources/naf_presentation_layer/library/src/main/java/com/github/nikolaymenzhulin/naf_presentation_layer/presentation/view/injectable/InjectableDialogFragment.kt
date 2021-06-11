package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable

import android.content.Context
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.fragment_delegate.InjectableFragmentDelegate

/**
 * The base dialog fragment with support for dependency injection.
 */
abstract class InjectableDialogFragment : AppCompatDialogFragment(), InjectableView, LifecycleObserver {

    private val delegate by lazy { InjectableFragmentDelegate(this) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate.onAttach()
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }

    /**
     * The callback that called after the onCreate call of the parent activity of the dialog fragment.
     */
    @CallSuper
    @OnLifecycleEvent(ON_CREATE)
    protected open fun onActivityCreate() {
        delegate.onActivityCreate()
    }
}