package com.example.busstation.repository2

import com.example.busstation.data2.Driver
import com.example.busstation.network.UserAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DriverRepo(private val userAPIService: UserAPIService) {

    suspend fun getDriverByName(name:String): Response<Driver> =
        withContext(Dispatchers.IO){
            userAPIService.getDriverByName(name).await()
        }
    suspend  fun getAllDriver(): Response<List<Driver>> =
        withContext(Dispatchers.IO){
            userAPIService.getAllDrivers().await()
        }
    suspend  fun insertDriver(user:Driver): Response<Driver> =
        withContext(Dispatchers.IO){
            userAPIService.insertDriver(user).await()
        }

}