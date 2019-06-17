package com.example.busstation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.busstation.data.Driver
import com.example.busstation.data.MYDatabase
import com.example.busstation.repository.DriverRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DriverVM(application: Application):AndroidViewModel(application) {
    private val driverRepo:DriverRepo
    val allUsers: LiveData<List<Driver>>
    var driver:MutableLiveData<Driver> =MutableLiveData()
    get() {return driver}
    set(value) {
        field =value
    }

    init {
        val driverDao = MYDatabase.getDatabase(application).driverDao()
        driverRepo = DriverRepo(driverDao)
        allUsers = driverRepo.getAllDriver()
    }
    fun insertDriver(driver:Driver) = viewModelScope.launch (Dispatchers.IO){
        driverRepo.insertDriver(driver)
    }
    fun updateDriver(driver:Driver) = viewModelScope.launch (Dispatchers.IO){
        driverRepo.updateDriver(driver)
    }
    fun deleteDriver(driver:Driver) = viewModelScope.launch (Dispatchers.IO){
        driverRepo.deleteDriver(driver)
    }

}