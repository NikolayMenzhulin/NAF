package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.fragment_delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Делегат, инкапсулирующий общую логику всех injectable fragment'ов.
 */
internal class InjectableFragmentDelegate<T>(
    private val fragment: T
) where T : Fragment, T : InjectableView, T : LifecycleObserver {

    fun onAttach() {
        fragment.requireActivity().lifecycle.addObserver(fragment)
    }

    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        @LayoutRes contentLayoutId: Int
    ): View? =
        inflater.inflate(contentLayoutId, container, false)

    fun onActivityCreate() {
        fragment.requireActivity().lifecycle.removeObserver(fragment)
        fragment.injector.inject()
    }

    fun onDestroy() {
        fragment.injector.clearComponent()
    }
}