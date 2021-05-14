package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.fragment.AbstractFragment
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.databinding.${viewBindingName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.injector.${injectorName}

/**
 * TODO Add a comment.
 */
class ${fragmentName} : AbstractFragment<${viewModelName}, ${viewBindingName}, ${navigatorName}>(
    ${viewBindingName}::class.java
) {

    override val vm: ${viewModelName} by viewModels()

    override val injector = ${injectorName}(this)

    override fun onObserveViewModelData() {
        // Do nothing.
    }
}