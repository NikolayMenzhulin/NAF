package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.injectable

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.base.InjectableView

/**
 * Базовая activity с поддержкой инъекции зависимостей.
 *
 * @param contentLayoutId layout id вёрстки для activity
 */
abstract class InjectableActivity(
    @LayoutRes contentLayoutId: Int
) : AppCompatActivity(contentLayoutId), InjectableView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        injector.inject()
    }

    override fun onDestroy() {
        super.onDestroy()
        injector.clearComponent()
    }
}