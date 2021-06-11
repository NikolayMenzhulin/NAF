package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable.InjectableFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_model.fragment_delegate.ViewModelFragmentDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.BaseViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelFactory
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * The base fragment with support for working with a view model.
 *
 * @property vmFactory the factory for creating the view model
 * @property vm the view model associated with the fragment
 */
abstract class ViewModelFragment<VM : BaseViewModel> : InjectableFragment() {

    @Inject
    lateinit var vmFactory: ViewModelFactory.Factory

    protected abstract val vm: VM

    private val delegate by lazy { ViewModelFragmentDelegate(this) }

    final override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        delegate.getDefaultViewModelProviderFactory(vmFactory)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        delegate.onSaveInstantState(vm)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        delegate.onDestroyView()
    }

    /**
     * Observe the data inside the [Flow].
     *
     * @param lifecycleOwner the lifecycle of a view to bind the subscription state to it
     * @param observer actions to perform when receiving data from the [Flow]
     *
     * @return the [Job] of the coroutine launched as a result of creating a subscription
     */
    protected fun <T> Flow<T>.observe(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit): Job =
        lifecycleOwner.lifecycleScope.launchWhenStarted {
            onEach(observer::invoke).collect()
        }.also(delegate::addCoroutineJob)
}