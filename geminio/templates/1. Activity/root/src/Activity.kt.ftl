package ${packageName}<#if (hasPackage)>.${screenPackageName}</#if>

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator.ScreenNavigator
<#if (isFragmentsContainer && applicationPackage??)>
import ${applicationPackage}.R
</#if>
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.databinding.${viewBindingName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.injector.${injectorName}

// TODO Register this activity inside AndroidManifest.xml
/**
 * TODO Add a comment.
 */
class ${activityName} : AbstractActivity<${viewModelName}, ${viewBindingName}, ScreenNavigator>(
    ${viewBindingName}::class.java
) {

    override val vm: ${viewModelName} by viewModels()

    override val injector = ${injectorName}(this)

    override fun createNavigator() = ScreenNavigator(this<#if (isFragmentsContainer)>, R.id.fragment_container</#if>)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }
}