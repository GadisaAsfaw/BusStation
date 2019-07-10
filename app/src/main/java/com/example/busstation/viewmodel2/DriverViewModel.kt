package com.example.busstation.viewmodel2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busstation.data2.Driver
import com.example.busstation.network.UserAPIService
import com.example.busstation.repository2.DriverRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class DriverViewModel:ViewModel() {
    private val driverRepo:DriverRepo

    init {
        val userAPIService = UserAPIService.geInstance()
        driverRepo = DriverRepo(userAPIService)
    }

    private  val _gDriver = MutableLiveData<Response<Driver>>()
    val gDriver: LiveData<Response<Driver>>
        get() = _gDriver

    private  val _gAllDrivers = MutableLiveData<Response<List<Driver>>>()
    val gAllDrivers: LiveData<Response<List<Driver>>>
        get() = _gAllDrivers

    private val _iDriver = MutableLiveData<Response<Driver>>()
    val iDriver : LiveData<Response<Driver>>
        get() =  _iDriver


    fun getDriverByName(name:String) = viewModelScope.launch {
        _gDriver.postValue(driverRepo.getDriverByName(name))
    }

    fun getAllDrivers() = viewModelScope.launch {
        _gAllDrivers.postValue(driverRepo.getAllDriver())
    }
    fun insertDriver(driver: Driver)=viewModelScope.launch {
        _iDriver.postValue(driverRepo.insertDriver(driver))
    }

}