package com.example.busstation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.busstation.data.MYDatabase
import com.example.busstation.data.User
import com.example.busstation.data.UserDao
import com.example.busstation.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserVM(application: Application):AndroidViewModel(application) {
    private val userRepo:UserRepo
    val allUsers: LiveData<List<User>>

    init {
        val userDao = MYDatabase.getDatabase(application).userDao()
        userRepo = UserRepo(userDao)
        allUsers = userRepo.getAllUser()
    }
   fun insertUser(user:User)= viewModelScope.launch(Dispatchers.IO){
       userRepo.insertUser(user)
   }
    fun updateUser(user:User)= viewModelScope.launch(Dispatchers.IO){
        userRepo.updateUser(user)
    }
    fun deleteUser(user:User)= viewModelScope.launch(Dispatchers.IO){
        userRepo.deleteUser(user)
    }




}