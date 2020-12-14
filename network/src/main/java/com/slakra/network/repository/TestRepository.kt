package com.slakra.network.repository

import com.slakra.database.dao.TestDao
import com.slakra.network.IApiService
import com.slakra.network.response.NetworkResult
import com.slakra.network.response.Test

class TestRepository(private val apiService: IApiService, private val testDao: TestDao): BaseRepository() {

    suspend fun test(): NetworkResult<Test> {
        return try {
            val response = apiService.test()
            execute(response)
        }catch (ex: Exception) {
            NetworkResult.NetworkException(ex.message!!)
        }
    }
}