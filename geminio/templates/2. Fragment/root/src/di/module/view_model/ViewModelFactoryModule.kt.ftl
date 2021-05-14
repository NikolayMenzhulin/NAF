package ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.${viewModelFactoryName}
import ${packageName}<#if hasPackage>.${screenPackageName}</#if>.di.module.${moduleName}
import dagger.Module

/**
 * Submodule of [${moduleName}].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<${viewModelFactoryName}>