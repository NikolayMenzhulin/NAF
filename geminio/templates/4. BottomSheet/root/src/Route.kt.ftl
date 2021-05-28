package ${packageName}<#if hasPackage>.${dialogPackageName}</#if>

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractDialogFragmentRoute

/**
 * Route for [${dialogFragmentName}].
 */
class ${routeName}() : AbstractDialogFragmentRoute<${dialogFragmentName}>() {

    constructor(args: Bundle?) : this()

    override fun getDialog(): ${dialogFragmentName} = ${dialogFragmentName}()
}