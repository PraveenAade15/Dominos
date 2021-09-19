package com.praveene.dominosapp.repository

import com.praveene.dominosapp.data.local.ResponseDao
import com.praveene.dominosapp.data.local.ResponseEntity
import com.praveene.dominosapp.data.model.ResponseItem
import com.praveene.dominosapp.data.network.ResponseApi
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val responseApi: ResponseApi,
    private val responseDao: ResponseDao
) {

    suspend fun getRemoteResponse(): Response<MutableList<ResponseItem>> {
        return responseApi.getRemoteResponse()
    }

    suspend fun insertData(responseEntity: ResponseEntity) {
        responseDao.insertData(responseEntity)
    }

    suspend fun getAllLocalData(): ResponseEntity {
        return responseDao.getAllLocalData()
    }
}