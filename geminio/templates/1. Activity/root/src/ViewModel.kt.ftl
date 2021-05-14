package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.common_deps.CommonViewModelDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [${activityName}].
 */
class ${viewModelName} @AssistedInject constructor(
   @Assisted commonDeps: CommonViewModelDeps
) : AbstractViewModel(commonDeps)

@AssistedFactory
interface ${viewModelFactoryName} : ViewModelAssistedFactory<${viewModelName}>