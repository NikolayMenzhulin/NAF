/*
  Copyright © 2021 Nikolay Menzhulin.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/
package com.github.nikolaymenzhulin.build_src

@Suppress("UNUSED")
abstract class PublishingConfig {

    companion object {

        const val GROUP_ID = "com.github.nikolaymenzhulin"

        const val LICENCE_NAME = "The Apache License, Version 2.0"
        const val LICENCE_URL = "http://www.apache.org/licenses/LICENSE-2.0.txt"

        const val DEVELOPER_NAME = "Nikolay Menzhulin"
        const val DEVELOPER_EMAIL = "NikolayMenzhulin@gmail.com"

        const val SCM_CONNECTION = "scm:https://github.com/NikolayMenzhulin/NAF.git"
        const val SCM_DEVELOPER_CONNECTION = "scm:git://github.com:NikolayMenzhulin/NAF.git"
        const val SCM_URL = "https://github.com/NikolayMenzhulin/NAF"

        private const val NAF_SERVICE_LAYER_PROJECT_NAME = "naf_service_layer"
        private const val NAF_PRESENTATION_LAYER_PROJECT_NAME = "naf_presentation_layer"

        @JvmStatic
        fun getName(projectName: String): String =
            when (projectName) {
                NAF_SERVICE_LAYER_PROJECT_NAME -> NafServiceLayerConfig.name
                NAF_PRESENTATION_LAYER_PROJECT_NAME -> NafPresentationLayerConfig.name
                else -> ""
            }

        @JvmStatic
        fun getDescription(projectName: String): String =
            when (projectName) {
                NAF_SERVICE_LAYER_PROJECT_NAME -> NafServiceLayerConfig.description
                NAF_PRESENTATION_LAYER_PROJECT_NAME -> NafPresentationLayerConfig.description
                else -> ""
            }

        @JvmStatic
        fun getUrl(projectName: String): String =
            when (projectName) {
                NAF_SERVICE_LAYER_PROJECT_NAME -> NafServiceLayerConfig.url
                NAF_PRESENTATION_LAYER_PROJECT_NAME -> NafPresentationLayerConfig.url
                else -> ""
            }
    }

    abstract val name: String
    abstract val description: String
    abstract val url: String
}

object NafServiceLayerConfig : PublishingConfig() {

    override val name: String = "NAF Service Layer"

    override val description: String =
        "The NAF component that provides everything you need to implement the service layer in your app."

    override val url: String = "https://github.com/NikolayMenzhulin/NAF/tree/main/sources/naf_service_layer"
}

object NafPresentationLayerConfig : PublishingConfig() {

    override val name: String = "NAF Presentation Layer"

    override val description: String =
        "The NAF component that provides everything you need to implement the presentation layer in your app."

    override val url: String = "https://github.com/NikolayMenzhulin/NAF/tree/main/sources/naf_presentation_layer"
}