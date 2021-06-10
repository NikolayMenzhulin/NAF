package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import android.content.Context
import android.content.Intent
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractActivityRoute

/**
 * Route for [${activityName}].
 */
class ${routeName}() : AbstractActivityRoute() {

    constructor(intent: Intent) : this()

    override fun getIntent(context: Context): Intent = Intent(context, ${activityName}::class.java)
}