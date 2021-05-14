<#if (hasParentComponent)>
    <#assign parentComponentDepsProviderImportVar = "import ${parentComponentPackagePath}.component.deps_provider.${shortParentComponentName}DepsProvider">
    <#assign parentComponentHolderImportVar = "import ${parentComponentPackagePath}.holder.${shortParentComponentName}ComponentHolder">
    <#assign parentComponentDependenciesVar = "dependencies = [${shortParentComponentName}DepsProvider::class], ">
    <#assign parentComponentMethodVar = ".${shortParentComponentName?uncap_first}DepsProvider(${shortParentComponentName}ComponentHolder.component)">
</#if>

package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
<#if (hasParentComponent)>
${parentComponentDepsProviderImportVar}
</#if>
<#if (hasParentComponent)>
${parentComponentHolderImportVar}
</#if>
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${activityName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.component.deps_provider.${depsProviderName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.${moduleName}
import dagger.Component

/**
 * Component for [${activityName}].
 */
@PerActivity
@Component(<#if (hasParentComponent)>${parentComponentDependenciesVar}</#if>modules = [${moduleName}::class])
interface ${componentName} : ViewComponent<${activityName}>, ${depsProviderName} {

    companion object {

        @Suppress("DEPRECATION")
        fun create(module: ${moduleName}): ${componentName} =
            Dagger${componentName}.builder()
                <#if (hasParentComponent)>
                ${parentComponentMethodVar}
                </#if>
                .${moduleName?uncap_first}(module)
                .build()
    }
}