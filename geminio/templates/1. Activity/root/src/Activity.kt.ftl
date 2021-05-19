package ${packageName}<#if (hasPackage)>.${screenPackageName}</#if>

import androidx.activity.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.activity.AbstractActivity
<#if (!isFragmentsContainer)>
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.navigator.ActivityNavigator
</#if>
<#if (isFragmentsContainer)>
<#if (applicationPackage??)>
import ${applicationPackage}.R
</#if>
</#if>
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.databinding.${viewBindingName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.injector.${injectorName}
<#if (isFragmentsContainer)>
import com.github.terrakok.cicerone.androidx.AppNavigator
</#if>

// TODO Register this activity inside AndroidManifest.xml
/**
 * TODO Add a comment.
 */
class ${activityName} : AbstractActivity<${viewModelName}, ${viewBindingName}, <#if (isFragmentsContainer)>AppNavigator<#else>ActivityNavigator</#if>>(
    ${viewBindingName}::class.java
) {

    override val vm: ${viewModelName} by viewModels()

    override val injector = ${injectorName}(this)

    override fun createNavigator() = <#if (isFragmentsContainer)>AppNavigator<#else>ActivityNavigator</#if>(this<#if (isFragmentsContainer)>, R.id.fragment_container</#if>)

    override fun onObserveViewModelCallback() {
        // Do nothing.
    }
}