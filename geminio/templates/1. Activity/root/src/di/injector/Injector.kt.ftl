package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.injector

import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.ViewComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.injector.AbstractViewInjector
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${activityName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.holder.${componentHolderName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.${moduleName}

/**
 * Injector for [${activityName}].
 */
class ${injectorName}(
    view: ${activityName},
    module: ${moduleName} = ${moduleName}(view)
) : AbstractViewInjector<${activityName}, ${moduleName}>(view, module) {

    override fun initComponent(module: ${moduleName}) {
        ${componentHolderName}.initComponent(module)
    }

    override fun getViewComponent(): ViewComponent<${activityName}> =
        ${componentHolderName}.component

    override fun clearComponent() {
        ${componentHolderName}.clearComponent()
    }
}