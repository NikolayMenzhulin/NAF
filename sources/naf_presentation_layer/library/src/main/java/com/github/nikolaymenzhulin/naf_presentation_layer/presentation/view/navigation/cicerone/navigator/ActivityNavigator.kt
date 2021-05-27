package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.screen.DialogScreen
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.ActivityScreen

/**
 * Реализация [Navigator] для осуществления навигации только между activity.
 *
 * @param activity activity, с которой связан навигатор
 */
open class ActivityNavigator(protected val activity: FragmentActivity) : Navigator {

    private val mainHandler = Handler(Looper.getMainLooper())

    override fun applyCommands(commands: Array<out Command>) {
        mainHandler.post { applyCommandsSync(commands) }
    }

    protected open fun applyCommandsSync(commands: Array<out Command>) {
        commands.forEach { command ->
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(command, e)
            }
        }
    }

    protected open fun applyCommand(command: Command) {
        when (command) {
            is Forward -> forward(command)
            is Replace -> replace(command)
            is BackTo -> backTo(command)
            is Back -> back()
        }
    }

    protected open fun errorOnApplyCommand(
        command: Command,
        error: RuntimeException
    ): Unit = throw error

    protected open fun forward(command: Forward) {
        when (val screen = command.screen) {
            is ActivityScreen -> checkAndStartActivity(screen)
            is DialogScreen -> openDialog(screen)
        }
    }

    protected open fun replace(command: Replace) {
        when (val screen = command.screen) {
            is ActivityScreen -> {
                checkAndStartActivity(screen)
                activity.finish()
            }
            is DialogScreen -> {
                throwNotImplementedCommand(command)
            }
        }
    }

    protected open fun backTo(command: BackTo) {
        throwNotImplementedCommand(command)
    }

    protected open fun back() {
        val fragment: Fragment? = activity.supportFragmentManager.fragments.lastOrNull()
        if (fragment != null && fragment is DialogFragment) {
            fragment.dismiss()
        } else {
            activity.finish()
        }
    }

    protected open fun onNotFoundActivityException(
        screen: ActivityScreen,
        activityIntent: Intent
    ) {
        // Empty realization.
    }

    private fun checkAndStartActivity(screen: ActivityScreen) {
        val activityIntent: Intent = screen.createIntent(activity)
        try {
            activity.startActivity(activityIntent, screen.startActivityOptions)
        } catch (e: ActivityNotFoundException) {
            onNotFoundActivityException(screen, activityIntent)
        }
    }

    private fun openDialog(screen: DialogScreen) {
        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val dialogFragment: DialogFragment = screen.createDialog(fragmentManager.fragmentFactory)
        dialogFragment.show(fragmentManager, screen.screenKey)
    }

    private fun throwNotImplementedCommand(command: Command) {
        throw NotImplementedError("Command ${command::class.simpleName} not supported for an activity/dialog")
    }
}