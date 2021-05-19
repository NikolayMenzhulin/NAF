package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.BaseViewModel

/**
 * Базовая activity, оборачивающая основные методы жизненного цикла.
 *
 * @param contentLayoutId layout id вёрстки для activity
 * @param vbClass класс view binding, связанный с activity
 */
abstract class LifecycleWrapperActivity<VM : BaseViewModel, VB : ViewBinding, N : AbstractNavigator<VM>>(
    @LayoutRes contentLayoutId: Int,
    vbClass: Class<VB>
) : NavigationActivity<VM, VB, N>(contentLayoutId, vbClass) {

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateCallback(savedInstanceState)
        onObserveViewModelData()
    }

    final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        onCreateCallback(savedInstanceState, persistentState)
        onObserveViewModelData()
    }

    final override fun onStart() {
        super.onStart()
        onStartCallback()
    }

    final override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        onRestoreInstanceStateCallback(savedInstanceState)
    }

    final override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        onRestoreInstanceStateCallback(savedInstanceState, persistentState)
    }

    final override fun onResume() {
        super.onResume()
        onResumeCallback()
    }

    final override fun onPause() {
        super.onPause()
        onPauseCallback()
    }

    final override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        onSaveInstanceStateCallback(outState)
    }

    final override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        onSaveInstanceStateCallback(outState, outPersistentState)
    }

    final override fun onStop() {
        super.onStop()
        onStopCallback()
    }

    final override fun onDestroy() {
        super.onDestroy()
        onDestroyCallback()
    }

    protected open fun onCreateCallback(savedInstanceState: Bundle?) {
        // Empty realization.
    }

    protected open fun onCreateCallback(savedInstanceState: Bundle?, persistableBundle: PersistableBundle?) {
        // Empty realization.
    }

    protected open fun onStartCallback() {
        // Empty realization.
    }

    protected open fun onRestoreInstanceStateCallback(savedInstanceState: Bundle) {
        // Empty realization.
    }

    protected open fun onRestoreInstanceStateCallback(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        // Empty realization.
    }

    protected open fun onResumeCallback() {
        // Empty realization.
    }

    protected open fun onPauseCallback() {
        // Empty realization.
    }

    protected open fun onSaveInstanceStateCallback(outState: Bundle) {
        // Empty realization.
    }

    protected open fun onSaveInstanceStateCallback(outState: Bundle, outPersistentState: PersistableBundle) {
        // Empty realization.
    }

    protected open fun onStopCallback() {
        // Empty realization.
    }

    protected open fun onDestroyCallback() {
        // Empty realization.
    }
}