package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.AbstractActivity
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.databinding.${viewBindingName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.injector.${injectorName}

// TODO Register this activity inside AndroidManifest.xml
// TODO Set app:startDestination parameter inside ${navGraphName}.xml
/**
 * TODO Add a comment.
 */
class ${activityName} : AbstractActivity<${viewModelName}, ${viewBindingName}, ${navigatorName}>(
    ${viewBindingName}::class.java
) {

    override val vm: ${viewModelName} by viewModels()

    override val injector = ${injectorName}(this)

    override fun onObserveViewModelData() {
        // Do nothing.
    }
}