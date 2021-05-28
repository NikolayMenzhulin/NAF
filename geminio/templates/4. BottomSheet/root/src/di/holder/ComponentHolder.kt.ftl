package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.component.${componentName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module.${moduleName}

/**
 * ComponentHolder for [${componentName}].
 */
object ${componentHolderName} : AbstractComponentHolder<${componentName}, ${moduleName}>() {

    override fun getComponentImpl(module: ${moduleName}): ${componentName} =
        ${componentName}.create(module)
}