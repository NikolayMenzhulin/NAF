package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

/**
 * Route for [${fragmentName}].
 */
class ${routeName}() : AbstractFragmentRoute<${fragmentName}>() {

    constructor(args: Bundle?) : this()

    override fun getFragment(): ${fragmentName} = ${fragmentName}()
}