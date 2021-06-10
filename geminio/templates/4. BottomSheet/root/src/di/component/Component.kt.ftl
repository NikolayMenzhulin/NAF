<#if (hasParentComponent)>
    <#assign parentComponentDepsProviderImportVar = "import ${parentComponentPackagePath}.component.deps_provider.${shortParentComponentName}DepsProvider">
    <#assign parentComponentHolderImportVar = "import ${parentComponentPackagePath}.holder.${shortParentComponentName}ComponentHolder">
    <#assign parentComponentDependenciesVar = "dependencies = [${shortParentComponentName}DepsProvider::class], ">
    <#assign parentComponentMethodVar = ".${shortParentComponentName?uncap_first}DepsProvider(${shortParentComponentName}ComponentHolder.component)">
</#if>

package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
<#if (hasParentComponent)>
${parentComponentDepsProviderImportVar}
</#if>
<#if (hasParentComponent)>
${parentComponentHolderImportVar}
</#if>
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.${dialogFragmentName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.component.deps_provider.${depsProviderName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module.${moduleName}
import dagger.Component

/**
 * Component for [${dialogFragmentName}].
 */
@PerDialog
@Component(<#if (hasParentComponent)>${parentComponentDependenciesVar}</#if>modules = [${moduleName}::class])
interface ${componentName} : ViewComponent<${dialogFragmentName}>, ${depsProviderName} {

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