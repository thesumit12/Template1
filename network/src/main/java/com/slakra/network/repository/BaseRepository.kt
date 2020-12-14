package com.slakra.network.repository

import com.slakra.network.response.NetworkResult
import retrofit2.Response

open class BaseRepository {

    fun <T> execute(response: Response<T>): NetworkResult<T> {
        return if (response.isSuccessful) {
            if (response.body() != null) {
                NetworkResult.Success(response.body()!!)
            }else {
                NetworkResult.InvalidData
            }
        }else {
            when(response.code()) {
                403 -> NetworkResult.HttpErrors.ResourceForbidden(response.message())
                404 -> NetworkResult.HttpErrors.ResourceNotFound(response.message())
                500 -> NetworkResult.HttpErrors.InternalServerError(response.message())
                502 -> NetworkResult.HttpErrors.BadGateWay(response.message())
                301 -> NetworkResult.HttpErrors.ResourceRemoved(response.message())
                302 -> NetworkResult.HttpErrors.RemovedResourceFound(response.message())
                else -> NetworkResult.Error(response.message())
            }
        }
    }
}