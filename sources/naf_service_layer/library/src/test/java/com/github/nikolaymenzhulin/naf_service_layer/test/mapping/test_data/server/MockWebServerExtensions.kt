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
package com.github.nikolaymenzhulin.naf_service_layer.test.mapping.test_data.server

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.util.concurrent.TimeUnit.MILLISECONDS

fun MockWebServer.enqueueResponse(
    responseCode: Int,
    responseBody: String? = null,
) {
    MockResponse()
        .setResponseCode(responseCode)
        .setBodyDelay(delay = 300, unit = MILLISECONDS)
        .apply { responseBody?.let { setBody(it) } }
        .also { enqueue(it) }
}