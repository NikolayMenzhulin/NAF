package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel

/**
 * Базовый fragment, оборачивающий основные методы жизненного цикла.
 *
 * @param contentLayoutId layout id вёрстки для fragment
 * @param vbClass класс view binding, связанный с fragment
 */
abstract class LifecycleWrapperFragment<VM : BaseViewModel, VB : ViewBinding, N : AbstractNavigator<VM>>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : NavigationFragment<VM, VB, N>(contentLayoutId, vbClass) {

    final override fun onAttach(context: Context) {
        super.onAttach(context)
        onAttachCallback(context)
    }

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateCallback(savedInstanceState)
    }

    final override fun onActivityCreate() {
        super.onActivityCreate()
        onActivityCreateCallback()
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        super.onCreateView(inflater, container, savedInstanceState)

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreatedCallback(view, savedInstanceState)
        onObserveViewModelData()
    }

    @Suppress("DEPRECATION")
    final override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onActivityCreatedCallback(savedInstanceState)
    }

    final override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        onViewStateRestoredCallback(savedInstanceState)
    }

    final override fun onStart() {
        super.onStart()
        onStartCallback()
    }

    final override fun onResume() {
        super.onResume()
        onResumeCallback()
    }

    final override fun onPause() {
        super.onPause()
        onPauseCallback()
    }

    final override fun onStop() {
        super.onStop()
        onStopCallback()
    }

    final override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        onSaveInstanceStateCallback(outState)
    }

    final override fun onDestroyView() {
        super.onDestroyView()
        onDestroyViewCallback()
    }

    final override fun onDestroy() {
        super.onDestroy()
        onDestroyCallback()
    }

    final override fun onDetach() {
        super.onDetach()
        onDetachCallback()
    }

    protected open fun onAttachCallback(context: Context) {
        // Empty realization.
    }

    protected open fun onCreateCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onActivityCreateCallback() {
        // Empty realization.
    }

    protected open fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onActivityCreatedCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onViewStateRestoredCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onStartCallback() {
        // Empty realization.
    }

    protected open fun onResumeCallback() {
        // Empty realization.
    }

    protected open fun onPauseCallback() {
        // Empty realization.
    }

    protected open fun onStopCallback() {
        // Empty realization.
    }

    protected open fun onSaveInstanceStateCallback(outState: Bundle) {
        // Empty realization.
    }

    protected open fun onDestroyViewCallback() {
        // Empty realization.
    }

    protected open fun onDestroyCallback() {
        // Empty realization.
    }

    protected open fun onDetachCallback() {
        // Empty realization.
    }
}