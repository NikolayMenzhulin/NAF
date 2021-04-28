package com.github.nikolaymenzhulin.naf_service_layer_sample.utils

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.adapter.FlowResponseCallAdapterFactory
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.MILLISECONDS

object MockServer {

    private val server = MockWebServer()

    lateinit var retrofit: Retrofit
        private set

    suspend fun initRetrofit() {
        withContext(IO) {
            retrofit =
                Retrofit.Builder()
                    .baseUrl(server.url("/"))
                    .addCallAdapterFactory(FlowResponseCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }

    fun enqueueResponse(userName: String) {
        MockResponse()
            .setResponseCode(200)
            .setBody(getUserResponseJson(userName))
            .setBodyDelay(delay = 500, unit = MILLISECONDS)
            .also { server.enqueue(it) }
    }

    private fun getUserResponseJson(userName: String) = """{"name":"$userName"}"""
}