package com.slakra.network.response

/**
 * Generic class to handle Network Response
 * @author sumitlakra
 * @date 11/20/2020
 */
sealed class NetworkResult<out T> {
    data class Success<T>(val data: T): NetworkResult<T>()
    object InvalidData: NetworkResult<Nothing>()
    data class Error(val errorMsg: String): NetworkResult<Nothing>()
    data class NetworkException(val exceptionMsg: String): NetworkResult<Nothing>()
    sealed class HttpErrors: NetworkResult<Nothing>() {
        data class ResourceForbidden(val exceptionMsg: String) : HttpErrors()
        data class ResourceNotFound(val exceptionMsg: String) : HttpErrors()
        data class InternalServerError(val exceptionMsg: String) : HttpErrors()
        data class BadGateWay(val exceptionMsg: String) : HttpErrors()
        data class ResourceRemoved(val exceptionMsg: String) : HttpErrors()
        data class RemovedResourceFound(val exceptionMsg: String) : HttpErrors()
    }
}