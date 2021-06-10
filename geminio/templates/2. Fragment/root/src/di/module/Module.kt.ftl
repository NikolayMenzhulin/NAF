package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${fragmentName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${routeName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.component.${componentName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [${componentName}].
 */
@Module(includes = [ViewModelFactoryModule::class])
class ${moduleName}(view: ${fragmentName}) :
    FragmentModule<${routeName}>(${routeName}(view.arguments))