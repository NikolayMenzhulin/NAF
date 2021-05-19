package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age

import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.AbstractNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps.CommonNavigatorDeps
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.factory.NavigatorAssistedFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.util.constants.EXTRA_FIRST
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.io.Serializable

/**
 * Navigator for [GenerateAgeFragment].
 */
class GenerateAgeFragmentNavigator @AssistedInject constructor(
    @Assisted override val vm: GenerateAgeFragmentViewModel,
    commonDeps: CommonNavigatorDeps
) : AbstractNavigator<GenerateAgeFragmentViewModel>(commonDeps) {

    init {
        setUserBuilder()
    }

    fun backToUserListScreen() {
        val createUserFlowResult: Serializable? = vm.userBuilder?.build()
        createUserFlowResult?.let { setNavigationResult(R.id.userListFragment, EXTRA_FIRST, createUserFlowResult) }
        navController.popBackStack(R.id.userListFragment, false)
    }

    private fun setUserBuilder() {
        val userBuilder: UserDM.Builder? = arguments?.get(EXTRA_FIRST) as? UserDM.Builder
        userBuilder?.let(vm::userBuilder::set)
    }
}

@AssistedFactory
interface GenerateAgeFragmentNavigatorFactory :
    NavigatorAssistedFactory<GenerateAgeFragmentNavigator, GenerateAgeFragmentViewModel>