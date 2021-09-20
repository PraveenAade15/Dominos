package com.praveene.dominosapp.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.praveene.dominosapp.data.local.ResponseEntity
import com.praveene.dominosapp.data.model.ResponseItem
import com.praveene.dominosapp.repository.Repository
import com.praveene.dominosapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    var responseData: MutableLiveData<NetworkResult<MutableList<ResponseItem>>> =
        MutableLiveData()

    var error: String? = null

    fun getResponseData() {
        viewModelScope.launch {
            responseData.value = NetworkResult.Loading()


            if (hasInternetConnection()) {
                val response = repository.getRemoteResponse()

                when {
                    response.isSuccessful -> {

                        responseData.value = NetworkResult.Success(response.body()!!)
                        withContext(Dispatchers.IO) {
                            val responseEntity = ResponseEntity(response.body()!!)
                            repository.insertData(responseEntity)
                        }
                    }
                    else -> {
                        error = response.message()

                    }
                }

                val listData = repository.getAllLocalData().responseItem
                if (!listData.isNullOrEmpty()) {
                    responseData.value = NetworkResult.Success(listData)
                } else {
                    responseData.value = NetworkResult.Error(error)
                }

            } else {
                val listData = repository.getAllLocalData().responseItem
                if (!listData.isNullOrEmpty()) {
                    responseData.value = NetworkResult.Success(listData)
                } else {
                    responseData.value = NetworkResult.Error("No Internet Connection")
                }
            }
        }
    }


    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false;
        }
    }
}