package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [${activityName}].
 */
 @PerActivity
 class ${navDelegateName} @Inject constructor(
     override val router: Router,
     override val route: ${routeName}
 ) : AbstractNavDelegate<Router, ${routeName}>()