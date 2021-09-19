package com.praveene.dominosapp.data.network

import com.praveene.dominosapp.data.model.ResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ResponseApi {

    @GET(RESPONSE_END_URL)
    suspend fun getRemoteResponse(
    ): Response<MutableList<ResponseItem>>
}