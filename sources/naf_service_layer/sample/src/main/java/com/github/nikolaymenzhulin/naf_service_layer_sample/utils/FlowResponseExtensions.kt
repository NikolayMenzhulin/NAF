package com.github.nikolaymenzhulin.naf_service_layer_sample.utils

import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.response.Response
import com.github.nikolaymenzhulin.flow_response_retrofit_adapter.typealiases.FlowResponse
import kotlinx.coroutines.flow.map

fun <In, Out> FlowResponse<In>.mapResponseData(mapper: (In) -> Out): FlowResponse<Out> =
    map { response ->
        with(response) {
            when (this) {
                is Response.Loading -> Response.Loading
                is Response.Empty -> Response.Empty
                is Response.Success -> Response.Success(data = mapper(getData()))
                is Response.Error -> Response.Error(error = getError())
            }
        }
    }