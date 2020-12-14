package com.slakra.network

import com.slakra.network.response.Test
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface IApiService {

    @Headers("Content-Type: application/json")
    @GET
    suspend fun test(): Response<Test>
}