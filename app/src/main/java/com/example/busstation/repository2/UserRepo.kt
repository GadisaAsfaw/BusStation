package com.example.busstation.repository2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.busstation.data.UserDao
import com.example.busstation.data2.User
import com.example.busstation.network.UserAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepo(private val userAPIService: UserAPIService) {

    suspend fun getUserByName(name:String):Response<User> =
            withContext(Dispatchers.IO){
                userAPIService.getUserByName(name).await()
            }
    suspend  fun getUAllUser():Response<List<User>> =
            withContext(Dispatchers.IO){
                userAPIService.getAllUsers().await()
            }
    suspend  fun insertUser(user:User):Response<User> =
            withContext(Dispatchers.IO){
                userAPIService.insertUser(user).await()
            }


}