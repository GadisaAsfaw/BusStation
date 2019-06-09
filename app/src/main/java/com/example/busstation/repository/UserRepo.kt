package com.example.busstation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.busstation.data.User
import com.example.busstation.data.UserDao

class UserRepo(private val userDao:UserDao) {

    fun insertUser(user:User){
        userDao.insertUser(user)
    }
    fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    fun updateUser(user: User){
        userDao.updateUser(user)
    }
    //fun getUser(name:String):MutableLiveData<User> = userDao.getUser(name)
    fun getAllUser():LiveData<List<User>> = userDao.getAllUser()
}