package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigator.common_deps

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController

/**
 * Класс, содержащий основные зависимости, которые необходимы navigator.
 *
 * @param navController [NavController], связанный с navigator
 * @param arguments аргументы, полученные от предыдущего экрана в стэке навигации
 * @param lifecycleOwner жизненный цикл view, к которому привязан жизненный цикл navigator
 */
class CommonNavigatorDeps(
    val navController: NavController,
    val arguments: Bundle?,
    val lifecycleOwner: LifecycleOwner
)