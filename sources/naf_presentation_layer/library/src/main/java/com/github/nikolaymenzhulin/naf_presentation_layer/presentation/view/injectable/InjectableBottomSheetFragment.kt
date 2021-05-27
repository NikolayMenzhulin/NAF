package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable

import android.content.Context
import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.fragment_delegate.InjectableFragmentDelegate
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Базовый bottom sheet fragment с поддержкой инъекции зависимостей.
 */
abstract class InjectableBottomSheetFragment : BottomSheetDialogFragment(), InjectableView, LifecycleObserver {

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
     * Callback, который будет вызван сразу после вызова onCreate у activity, с которой связан bottom sheet fragment.
     */
    @CallSuper
    @OnLifecycleEvent(ON_CREATE)
    protected open fun onActivityCreate() {
        delegate.onActivityCreate()
    }
}