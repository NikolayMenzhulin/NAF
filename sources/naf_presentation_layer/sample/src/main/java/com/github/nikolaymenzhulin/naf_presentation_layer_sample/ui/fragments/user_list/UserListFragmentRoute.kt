package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.user_list

import android.os.Bundle
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.route.AbstractFragmentRoute

/**
 * Route for [UserListFragment].
 */
class UserListFragmentRoute() : AbstractFragmentRoute<UserListFragment>() {

    constructor(args: Bundle?) : this()

    override fun getFragment(): UserListFragment = UserListFragment()
}