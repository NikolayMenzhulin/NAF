<#if (hasParentComponent)>
    <#assign parentComponentDepsProviderImportVar = "import ${parentComponentPackagePath}.component.deps_provider.${shortParentComponentName}DepsProvider">
</#if>

package ${packageName}.di.component.deps_provider

<#if (hasParentComponent)>
${parentComponentDepsProviderImportVar}
</#if>
import ${packageName}.di.component.${componentName}

/**
 * DepsProvider for [${componentName}].
 */
interface ${depsProviderName}<#if (hasParentComponent)> : ${shortParentComponentName}DepsProvider</#if>