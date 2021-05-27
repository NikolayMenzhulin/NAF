package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractFragment
<#if (applicationPackage??)>
import ${applicationPackage}.R
</#if>
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.databinding.${viewBindingName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.injector.${injectorName}
import com.github.terrakok.cicerone.androidx.AppNavigator

/**
 * TODO Add a comment.
 */
class ${fragmentName} : AbstractFragment<${viewModelName}, ${viewBindingName}, AppNavigator>(
    ${viewBindingName}::class.java
) {

    override val vm: ${viewModelName} by viewModels()

    override val injector = ${injectorName}(this)

    override fun createNavigator() = AppNavigator(requireActivity(), R.id.fragment_container)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }
}