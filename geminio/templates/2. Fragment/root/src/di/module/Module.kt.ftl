package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.FragmentModule
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${fragmentName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.component.${componentName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.navigator.NavigatorFactoryModule
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [${componentName}].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class ${moduleName}(fragment: ${fragmentName}) : FragmentModule(fragment)