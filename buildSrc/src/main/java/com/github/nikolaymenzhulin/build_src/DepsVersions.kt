package com.github.nikolaymenzhulin.build_src

sealed class DepsVersions {

    object GradlePlugin : DepsVersions() {

        const val gradleV = "4.1.3"
        const val kotlinGradlePluginV = "1.4.32"
        const val androidJUnit5V = "1.7.1.1"
    }

    object Kotlin : DepsVersions() {

        const val kotlinStdlibJdk8V = GradlePlugin.kotlinGradlePluginV
        const val kotlinxCoroutinesCoreV = "1.4.3"
    }

    sealed class Android : DepsVersions() {

        companion object {

            const val appCompatV = "1.2.0"
            const val multidexV = "2.0.1"
        }

        object Ktx : Android() {

            const val coreKtxV = "1.3.2"
            const val lifecycleRuntimeKtxV = "2.4.0-alpha01"
            const val activityKtxV = "1.2.2"
            const val fragmentKtxV = "1.3.3"
            const val navigationFragmentKtxV = "2.3.5"
        }

        object Test : Android() {

            const val baseTestDepsV = "1.3.0"
            const val espressoV = "3.3.0"
        }
    }

    object NikolayMenzhulin : DepsVersions() {

        const val flowResponseRetrofitAdapterV = "1.2.1"
        const val simpleStorageV = "1.0.1"
        const val loggerV = "1.1.1"
    }

    object Dagger : DepsVersions() {

        const val daggerV = "2.34"
    }

    object OkHttp : DepsVersions() {

        const val okHttpV = "4.9.1"
    }

    object Retrofit : DepsVersions() {

        const val retrofitV = "2.9.0"
    }

    object Room : DepsVersions() {

        const val roomV = "2.3.0"
    }

    object JUnit : DepsVersions() {

        const val junitV = "5.7.1"
        const val androidJUnitV = "1.2.2"
    }
}