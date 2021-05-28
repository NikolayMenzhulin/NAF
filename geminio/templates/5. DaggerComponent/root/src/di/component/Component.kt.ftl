<#if (hasParentComponent)>
    <#assign parentComponentDepsProviderImportVar = "import ${parentComponentPackagePath}.component.deps_provider.${shortParentComponentName}DepsProvider">
    <#assign parentComponentHolderImportVar = "import ${parentComponentPackagePath}.holder.${shortParentComponentName}ComponentHolder">
    <#assign parentComponentDependenciesVar = "dependencies = [${shortParentComponentName}DepsProvider::class], ">
    <#assign parentComponentMethodVar = ".${shortParentComponentName?uncap_first}DepsProvider(${shortParentComponentName}ComponentHolder.component)">
</#if>

package ${packageName}.di.component

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
<#if (hasParentComponent)>
${parentComponentDepsProviderImportVar}
</#if>
<#if (hasParentComponent)>
${parentComponentHolderImportVar}
</#if>
import ${packageName}.di.component.deps_provider.${depsProviderName}
import ${packageName}.di.module.${moduleName}
import ${packageName}.di.scope.${scopeName}
import dagger.Component

/**
 * TODO Add a comment.
 */
@${scopeName}
@Component(<#if (hasParentComponent)>${parentComponentDependenciesVar}</#if>modules = [${moduleName}::class])
interface ${componentName} : DaggerComponent, ${depsProviderName} {

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