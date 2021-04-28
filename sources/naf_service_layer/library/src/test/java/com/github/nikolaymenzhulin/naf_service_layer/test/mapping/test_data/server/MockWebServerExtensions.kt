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