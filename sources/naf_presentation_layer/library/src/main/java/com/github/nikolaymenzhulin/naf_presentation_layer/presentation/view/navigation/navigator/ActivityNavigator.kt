package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.navigator

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.github.nikolaymenzhulin.logger.Logger
import com.github.terrakok.cicerone.*
import com.github.terrakok.cicerone.androidx.ActivityScreen

/**
 * Реализация [Navigator] для осуществления навигации только между activity.
 *
 * @param activity activity, с которой связан навигатор
 */
open class ActivityNavigator(protected val activity: Activity) : Navigator {

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
        applyCommandIfActivityScreen(command) { screen ->
            checkAndStartActivity(screen)
        }
    }

    protected open fun replace(command: Replace) {
        applyCommandIfActivityScreen(command) { screen ->
            checkAndStartActivity(screen)
            activity.finish()
        }
    }

    protected open fun backTo(command: BackTo) {
        throw NotImplementedError("Command ${command::class.simpleName} not supported for an activity")
    }

    protected open fun back() {
        activity.finish()
    }

    protected open fun onNotFoundActivityException(
        screen: ActivityScreen,
        activityIntent: Intent
    ) {
        // Empty realization.
    }

    private fun applyCommandIfActivityScreen(
        command: Command,
        action: (ActivityScreen) -> Unit
    ) {
        val screen: Screen =
            when (command) {
                is Forward -> command.screen
                is Replace -> command.screen
                else -> return
            }
        if (screen is ActivityScreen) {
            action.invoke(screen)
        } else {
            Logger.e("An attempt to apply command ${command::class.simpleName} to not activity screen $screen")
        }
    }

    private fun checkAndStartActivity(screen: ActivityScreen) {
        val activityIntent: Intent = screen.createIntent(activity)
        try {
            activity.startActivity(activityIntent, screen.startActivityOptions)
        } catch (e: ActivityNotFoundException) {
            onNotFoundActivityException(screen, activityIntent)
        }
    }
}