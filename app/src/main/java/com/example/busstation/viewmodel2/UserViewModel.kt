package com.example.busstation.viewmodel2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busstation.data2.User
import com.example.busstation.network.UserAPIService
import com.example.busstation.repository2.UserRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel :ViewModel(){
    private val userRepo:UserRepo

    init {
        val userAPIService = UserAPIService.geInstance()
        userRepo = UserRepo(userAPIService)
    }

    private  val _gUser = MutableLiveData<Response<User>>()
    val gUser:LiveData<Response<User>>
                get() = _gUser

    private  val _gAllUsers = MutableLiveData<Response<List<User>>>()
    val gAllUsers:LiveData<Response<List<User>>>
        get() = _gAllUsers

    private val _iUser = MutableLiveData<Response<User>>()
    val iUser :LiveData<Response<User>>
        get() =  _iUser


    fun getUserByName(name:String) = viewModelScope.launch {
        _gUser.postValue(userRepo.getUserByName(name))
    }

    fun getAllUsers() = viewModelScope.launch {
        _gAllUsers.postValue(userRepo.getUAllUser())
    }
    fun insertUser(user: User)=viewModelScope.launch {
        _iUser.postValue(userRepo.insertUser(user))
    }














}