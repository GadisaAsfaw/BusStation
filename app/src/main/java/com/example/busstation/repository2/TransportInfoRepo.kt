package com.example.busstation.repository2

import com.example.busstation.data2.TransportInfo
import com.example.busstation.network.UserAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class TransportInfoRepo(private val userAPIService: UserAPIService) {

    suspend fun getTInfoByDriverId(id:String): Response<TransportInfo> =
        withContext(Dispatchers.IO){
            userAPIService.getTInfoByDriverId(id).await()
        }
    suspend  fun getAllTInfo(): Response<List<TransportInfo>> =
        withContext(Dispatchers.IO){
            userAPIService.getAllTInfos().await()
        }
    suspend  fun insertTInfo(info:TransportInfo): Response<TransportInfo> =
        withContext(Dispatchers.IO){
            userAPIService.insertTInfo(info).await()
        }

}