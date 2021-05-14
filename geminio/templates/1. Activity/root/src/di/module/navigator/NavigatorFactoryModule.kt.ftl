package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.navigator

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseNavigatorFactoryModule
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${navigatorName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${navigatorFactoryName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${viewModelName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.${moduleName}
import dagger.Module

/**
 * Submodule of [${moduleName}].
 */
@Module
interface NavigatorFactoryModule :
    BaseNavigatorFactoryModule<${navigatorFactoryName}, ${navigatorName}, ${viewModelName}>