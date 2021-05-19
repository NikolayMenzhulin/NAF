package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list

import com.github.nikolaymenzhulin.naf_presentation_layer.di.scope.PerFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.navigation_delegate.AbstractNavDelegate
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.UserDM
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragment
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_age.GenerateAgeFragmentNavDelegate.Companion.CREATE_USER_FLOW_RESULT
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.create_user.generate_name.GenerateNameFragmentRoute
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

/**
 * NavDelegate for [GenerateAgeFragment].
 */
@PerFragment
class UserListFragmentNavDelegate @Inject constructor(
    override val router: Router,
    override val route: UserListFragmentRoute
) : AbstractNavDelegate<Router, UserListFragmentRoute>() {

    fun goToCreateUserFlow() {
        router.navigateTo(GenerateNameFragmentRoute()())
    }

    suspend fun getCreateUserFlowResult(): UserDM = router.getScreenResult(CREATE_USER_FLOW_RESULT)
}