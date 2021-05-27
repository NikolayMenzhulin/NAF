package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable

import android.content.Context
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle.Event.ON_CREATE
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовый fragment с поддержкой инъекции зависимостей.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 */
abstract class InjectableFragment(
    @LayoutRes contentLayoutId: Int
) : Fragment(contentLayoutId), InjectableView, LifecycleObserver {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().lifecycle.addObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        injector.clearComponent()
    }

    /**
     * Callback, который будет вызван сразу после вызова onCreate у activity, с которой связан fragment.
     */
    @CallSuper
    @OnLifecycleEvent(ON_CREATE)
    protected open fun onActivityCreate() {
        requireActivity().lifecycle.removeObserver(this)
        injector.inject()
    }
}