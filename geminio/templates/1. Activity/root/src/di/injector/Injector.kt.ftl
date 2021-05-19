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
    private val view: ${activityName}
) : AbstractViewInjector<${activityName}>(view) {

    override fun initComponent() {
        ${componentHolderName}.initComponent(${moduleName}(view))
    }

    override fun getViewComponent(): ViewComponent<${activityName}> =
        ${componentHolderName}.component

    override fun clearComponent() {
        ${componentHolderName}.clearComponent()
    }
}