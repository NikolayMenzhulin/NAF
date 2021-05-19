package ${packageName}.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.di.holder.AbstractComponentHolder
import ${packageName}.di.component.${componentName}
import ${packageName}.di.module.${moduleName}

/**
 * ComponentHolder for [${componentName}].
 */
object ${componentHolderName} : AbstractComponentHolder<${componentName}, ${moduleName}>() {

    override fun getComponentImpl(module: ${moduleName}): ${componentName} =
        ${componentName}.create(module)
}