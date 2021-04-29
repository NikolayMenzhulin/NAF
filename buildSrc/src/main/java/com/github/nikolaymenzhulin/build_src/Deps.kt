package com.github.nikolaymenzhulin.build_src

import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Companion.appCompatV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Ktx.activityKtxV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Ktx.coreKtxV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Ktx.fragmentKtxV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Ktx.lifecycleRuntimeKtxV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Ktx.navigationFragmentKtxV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Test.coreV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Android.Test.runnerV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Dagger.daggerV
import com.github.nikolaymenzhulin.build_src.DepsVersions.GradlePlugin.androidJUnit5V
import com.github.nikolaymenzhulin.build_src.DepsVersions.GradlePlugin.gradleV
import com.github.nikolaymenzhulin.build_src.DepsVersions.GradlePlugin.kotlinGradlePluginV
import com.github.nikolaymenzhulin.build_src.DepsVersions.JUnit.androidJUnitV
import com.github.nikolaymenzhulin.build_src.DepsVersions.JUnit.junitV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Kotlin.kotlinStdlibJdk8V
import com.github.nikolaymenzhulin.build_src.DepsVersions.Kotlin.kotlinxCoroutinesCoreV
import com.github.nikolaymenzhulin.build_src.DepsVersions.NikolayMenzhulin.flowResponseRetrofitAdapterV
import com.github.nikolaymenzhulin.build_src.DepsVersions.NikolayMenzhulin.loggerV
import com.github.nikolaymenzhulin.build_src.DepsVersions.NikolayMenzhulin.simpleStorageV
import com.github.nikolaymenzhulin.build_src.DepsVersions.OkHttp.okHttpV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Retrofit.retrofitV
import com.github.nikolaymenzhulin.build_src.DepsVersions.Room.roomV

@Suppress("UNUSED")
sealed class Deps {

    object GradlePlugin : Deps() {

        const val gradle = "com.android.tools.build:gradle:$gradleV"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinGradlePluginV"
        const val androidJUnit5 = "de.mannodermaus.gradle.plugins:android-junit5:$androidJUnit5V"
    }

    object Kotlin : Deps() {

        const val kotlinStdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinStdlibJdk8V"
        const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesCoreV"
    }

    sealed class Android : Deps() {

        companion object {

            const val appCompat = "androidx.appcompat:appcompat:$appCompatV"
        }

        object Ktx : Android() {

            const val coreKtx = "androidx.core:core-ktx:$coreKtxV"
            const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxV"
            const val activityKtx = "androidx.activity:activity-ktx:$activityKtxV"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentKtxV"
            const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationFragmentKtxV"
        }

        object Test : Android() {

            const val core = "androidx.test:core:$coreV"
            const val runner = "androidx.test:runner:$runnerV"
        }
    }

    object NikolayMenzhulin : Deps() {

        const val flowResponseRetrofitAdapter =
            "com.github.nikolaymenzhulin:flow-response-retrofit-adapter:$flowResponseRetrofitAdapterV"

        const val simpleStorage = "com.github.nikolaymenzhulin:simple-storage:$simpleStorageV"
        const val logger = "com.github.nikolaymenzhulin:logger:$loggerV"
    }

    object Dagger : Deps() {

        const val dagger = "com.google.dagger:dagger:$daggerV"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerV"
    }

    object OkHttp : Deps() {

        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpV"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$okHttpV"
    }

    object Retrofit : Deps() {

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitV"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitV"
    }

    object Room : Deps() {

        const val roomRuntime = "androidx.room:room-runtime:$roomV"
        const val roomCompiler = "androidx.room:room-compiler:$roomV"
        const val roomKtx = "androidx.room:room-ktx:$roomV"
    }

    object JUnit : Deps() {

        const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:$junitV"
        const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$junitV"
        const val androidTestCore = "de.mannodermaus.junit5:android-test-core:$androidJUnitV"
        const val androidTestRunner = "de.mannodermaus.junit5:android-test-runner:$androidJUnitV"
    }
}