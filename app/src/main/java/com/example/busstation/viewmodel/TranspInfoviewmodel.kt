package com.example.busstation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.busstation.data.MYDatabase
import com.example.busstation.data.TransportInfo
import com.example.busstation.repository.TranspInfoRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TranspInfoviewmodel(application: Application):AndroidViewModel(application) {
    private val transInfoRepo:TranspInfoRepo
    val allTransInfo: LiveData<List<TransportInfo>>

    init {
        val transportInfoDao = MYDatabase.getDatabase(application).transportInfoDao()
        transInfoRepo = TranspInfoRepo(transportInfoDao)
        allTransInfo = transInfoRepo.getAllInfo()
    }
    fun insertInfo(transportInfo: TransportInfo) = viewModelScope.launch (Dispatchers.IO){
        transInfoRepo.insertInfo(transportInfo)
    }
    fun updateInfo(transportInfo: TransportInfo) = viewModelScope.launch (Dispatchers.IO){
        transInfoRepo.updateInfo(transportInfo)
    }
    fun deleteInfo(transportInfo: TransportInfo) = viewModelScope.launch (Dispatchers.IO){
        transInfoRepo.deleteInfo(transportInfo)
    }

}