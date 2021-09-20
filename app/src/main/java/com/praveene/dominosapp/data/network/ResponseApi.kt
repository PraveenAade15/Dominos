package com.praveene.dominosapp.data.network

import com.praveene.dominosapp.data.model.ResponseItem
import com.praveene.dominosapp.util.Constants.RESPONSE_END_URL
import retrofit2.Response
import retrofit2.http.GET

interface ResponseApi {

    @GET(RESPONSE_END_URL)
    suspend fun getRemoteResponse(
    ): Response<MutableList<ResponseItem>>
}