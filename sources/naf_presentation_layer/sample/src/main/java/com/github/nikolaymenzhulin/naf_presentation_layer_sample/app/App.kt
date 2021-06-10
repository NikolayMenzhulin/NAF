package com.github.nikolaymenzhulin.naf_presentation_layer_sample.app

import androidx.multidex.MultiDexApplication
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.holder.AppComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.app.di.module.AppModule

@Suppress("UNUSED")
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AppComponentHolder.initComponent(AppModule(context = applicationContext))
    }

    override fun onTerminate() {
        super.onTerminate()
        AppComponentHolder.clearComponent()
    }
}