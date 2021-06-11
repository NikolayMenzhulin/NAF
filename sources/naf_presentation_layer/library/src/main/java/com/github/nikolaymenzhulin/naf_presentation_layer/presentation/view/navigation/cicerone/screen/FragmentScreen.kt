package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.nikolaymenzhulin.naf_presentation_layer.R
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.Creator

private typealias CiceroneFragmentScreen = com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Implementation of the [Screen] for fragments.
 *
 * @property enterAnimResId animation of the fragment to which we go
 * @property exitAnimResId animation of the fragment from which we move
 * @property popEnterAnimResId animation of the fragment to which we return
 * @property popExitAnimResId animation of the fragment from which we return
 */
interface FragmentScreen : CiceroneFragmentScreen {

    val enterAnimResId: Int?
    val exitAnimResId: Int?
    val popEnterAnimResId: Int?
    val popExitAnimResId: Int?

    companion object {

        operator fun invoke(
            key: String? = null,
            clearContainer: Boolean = true,
            @AnimatorRes @AnimRes enterAnimResId: Int? = R.anim.base_enter,
            @AnimatorRes @AnimRes exitAnimResId: Int? = R.anim.base_exit,
            @AnimatorRes @AnimRes popEnterAnimResId: Int? = R.anim.base_pop_enter,
            @AnimatorRes @AnimRes popExitAnimResId: Int? = R.anim.base_pop_exit,
            fragmentCreator: Creator<FragmentFactory, Fragment>
        ): FragmentScreen =
            object : FragmentScreen {

                override val screenKey = key ?: fragmentCreator::class.java.name
                override val clearContainer = clearContainer

                override val enterAnimResId: Int? = enterAnimResId
                override val exitAnimResId: Int? = exitAnimResId
                override val popEnterAnimResId: Int? = popEnterAnimResId
                override val popExitAnimResId: Int? = popExitAnimResId

                override fun createFragment(factory: FragmentFactory): Fragment = fragmentCreator.create(factory)
            }
    }
}