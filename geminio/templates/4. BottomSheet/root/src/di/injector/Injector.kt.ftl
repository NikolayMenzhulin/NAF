package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.${dialogFragmentName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.holder.${componentHolderName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module.${moduleName}

/**
 * Injector for [${dialogFragmentName}].
 */
class ${injectorName}(
    private val view: ${dialogFragmentName}
) : AbstractViewInjector<${dialogFragmentName}>(view) {

    override fun initComponent() {
        ${componentHolderName}.initComponent(${moduleName}(view))
    }

    override fun getViewComponent(): ViewComponent<${dialogFragmentName}> =
        ${componentHolderName}.component

    override fun clearComponent() {
        ${componentHolderName}.clearComponent()
    }
}