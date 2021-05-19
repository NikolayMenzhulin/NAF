package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list.UserListFragmentRoute
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [GenerateAgeFragment].
 */
@PerFragment
class GenerateAgeFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: GenerateAgeFragmentRoute
) : AbstractNavDelegate<Router, GenerateAgeFragmentRoute>() {

    companion object {

        const val CREATE_USER_FLOW_RESULT = "CREATE_USER_FLOW_RESULT"
    }

    fun setCreateUserFlowResult(userDM: UserDM) {
        router.apply {
            sendScreenResult(CREATE_USER_FLOW_RESULT, userDM)
            backTo(UserListFragmentRoute()())
        }
    }
}