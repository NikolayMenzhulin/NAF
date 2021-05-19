package ${packageName}<#if hasPackage>.${screenPackageName}</#if>

import androidx.lifecycle.SavedStateHandle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.AbstractViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.error_handler.ErrorHandler
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.factory.ViewModelAssistedFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * ViewModel for [${fragmentName}].
 */
class ${viewModelName} @AssistedInject constructor(
    @Assisted override val savedStateHandle: SavedStateHandle,
    override val errorHandler: ErrorHandler,
    override val navDelegate: ${navDelegateName}
) : AbstractViewModel<${navDelegateName}>()

@AssistedFactory
interface ${viewModelFactoryName} : ViewModelAssistedFactory<${viewModelName}>