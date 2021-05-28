package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentDialogModule
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.${dialogFragmentName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.${routeName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.component.${componentName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [${componentName}].
 */
@Module(includes = [ViewModelFactoryModule::class])
class ${moduleName}(view: ${dialogFragmentName}) :
    FragmentDialogModule<${routeName}>(${routeName}(view.arguments))