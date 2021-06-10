package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app

import androidx.multidex.MultiDexApplication
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.app.di.module.AppModule

@Suppress("UNUSED")
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AppComponentHolder.initComponent(AppModule())
    }

    override fun onTerminate() {
        super.onTerminate()
        AppComponentHolder.clearComponent()
    }
}