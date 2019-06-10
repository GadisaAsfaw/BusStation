package com.example.busstation.repository

import androidx.lifecycle.LiveData
import com.example.busstation.data.TransportInfo
import com.example.busstation.data.TransportInfoDao

class TranspInfoRepo(private val transportInfoDao: TransportInfoDao) {
   // class DriverRepo(private val driverDao:DriverDao) {

    fun insertInfo(transportInfo: TransportInfo){
        transportInfoDao.insertInfo(transportInfo)
    }
    fun updateInfo(transportInfo: TransportInfo){
        transportInfoDao.updateInfo(transportInfo)
    }
    fun deleteInfo(transportInfo: TransportInfo){
        transportInfoDao.deleteInfo(transportInfo)
    }
    fun getAllInfo():LiveData<List<TransportInfo>> = transportInfoDao.getAllInfo()
}