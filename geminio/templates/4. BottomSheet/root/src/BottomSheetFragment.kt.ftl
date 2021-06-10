package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractBottomSheetFragment
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.databinding.${viewBindingName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.injector.${injectorName}

/**
 * TODO Add a comment.
 */
class ${dialogFragmentName} : AbstractBottomSheetFragment<${viewModelName}, ${viewBindingName}>(
    ${viewBindingName}::class.java
) {

    override val vm: ${viewModelName} by viewModels()

    override val injector = ${injectorName}(this)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }
}