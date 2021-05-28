package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerDialog
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [${dialogFragmentName}].
 */
 @PerDialog
 class ${navDelegateName} @Inject constructor(
     override val router: Router,
     override val route: ${routeName}
 ) : AbstractNavDelegate<Router, ${routeName}>()