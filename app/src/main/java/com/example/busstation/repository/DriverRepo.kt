package com.example.busstation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.busstation.data.Driver
import com.example.busstation.data.DriverDao

class DriverRepo(private val driverDao:DriverDao) {

    fun insertDriver(driver:Driver){
        driverDao.insertDriver(driver)
    }
    fun deleteDriver(driver: Driver){
        driverDao.deleteDriver(driver)
    }
    fun updateDriver(driver: Driver){
        driverDao.updateDriver(driver)
    }
   // fun getDriver(name:String):MutableLiveData<Driver> = driverDao.getDriver(name)
    fun getAllDriver():LiveData<List<Driver>> = driverDao.getAllDriver()
}
