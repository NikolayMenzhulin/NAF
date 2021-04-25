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
        }

        object Ktx : Android() {

            const val coreKtxV = "1.3.2"
            const val lifecycleRuntimeKtxV = "2.3.1"
        }

        object Test : Android() {

            const val coreV = "1.3.0"
            const val runnerV = "1.3.0"
        }
    }

    object NikolayMenzhulin : DepsVersions() {

        const val flowResponseRetrofitAdapterV = "1.2.1"
        const val simpleStorageV = "1.0.1"
        const val loggerV = "1.1.1"
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