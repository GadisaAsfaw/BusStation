package com.example.busstation.viewmodel2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busstation.data2.TransportInfo
import com.example.busstation.network.UserAPIService
import com.example.busstation.repository2.TransportInfoRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class TransportInfoViewModel:ViewModel() {
    private val transportInfoRepo:TransportInfoRepo

    init {
        val userAPIService = UserAPIService.geInstance()
        transportInfoRepo = TransportInfoRepo(userAPIService)
    }

    private  val _gInfo = MutableLiveData<Response<TransportInfo>>()
    val gInfo: LiveData<Response<TransportInfo>>
        get() = _gInfo

    private  val _gAllInfos = MutableLiveData<Response<List<TransportInfo>>>()
    val gAllInfos: LiveData<Response<List<TransportInfo>>>
        get() = _gAllInfos

    private val _iInfo = MutableLiveData<Response<TransportInfo>>()
    val iUser : LiveData<Response<TransportInfo>>
        get() =  _iInfo


    fun getTinfoByDriverId(id:String) = viewModelScope.launch {
        _gInfo.postValue(transportInfoRepo.getTInfoByDriverId(id))
    }

    fun getAllInfos() = viewModelScope.launch {
        _gAllInfos.postValue(transportInfoRepo.getAllTInfo())
    }
    fun insertInfo(tinfo: TransportInfo)=viewModelScope.launch {
        _iInfo.postValue(transportInfoRepo.insertTInfo(tinfo))
    }
}