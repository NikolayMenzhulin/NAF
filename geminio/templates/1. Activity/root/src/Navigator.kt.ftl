package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * Navigator for [${activityName}].
 */
class ${navigatorName} @AssistedInject constructor(
    @Assisted override val vm: ${viewModelName},
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<${viewModelName}>(commonDeps)

@AssistedFactory
interface ${navigatorFactoryName} : NavigatorAssistedFactory<${navigatorName}, ${viewModelName}>