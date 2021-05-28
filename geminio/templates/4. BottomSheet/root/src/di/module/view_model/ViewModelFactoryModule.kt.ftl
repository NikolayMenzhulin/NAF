package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module.view_model

import com.github.nikolaymenzhulin.naf_presentation_layer.di.module.binds.BaseViewModelFactoryModule
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.${viewModelFactoryName}
import ${packageName}<#if hasPackage>.${dialogPackageName}</#if>.di.module.${moduleName}
import dagger.Module

/**
 * Submodule of [${moduleName}].
 */
@Module
interface ViewModelFactoryModule : BaseViewModelFactoryModule<${viewModelFactoryName}>