package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.provides.ActivityModule
import <#if applicationPackage??>${applicationPackage}<#else>${packageName}</#if>.R
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${activityName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.component.${componentName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.navigator.NavigatorFactoryModule
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.view_model.ViewModelFactoryModule
import dagger.Module

/**
 * Module for [${componentName}].
 */
@Module(includes = [ViewModelFactoryModule::class, NavigatorFactoryModule::class])
class ${moduleName}(activity: ${activityName}) : ActivityModule(activity, R.id.nav_host_fragment)