package com.example.busstation.viewmodel2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busstation.data2.BankAccount
import com.example.busstation.network.UserAPIService
import com.example.busstation.repository2.AccountRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class AccountViewModel:ViewModel() {
    private val accountRepo:AccountRepo

    init {
        val userAPIService = UserAPIService.geInstance()
        accountRepo = AccountRepo(userAPIService)
    }


    private  val _gAccount = MutableLiveData<Response<BankAccount>>()
    val gAccount: LiveData<Response<BankAccount>>
        get() = _gAccount

    private  val _gAllAccounts = MutableLiveData<Response<List<BankAccount>>>()
    val gAllAccounts: LiveData<Response<List<BankAccount>>>
        get() = _gAllAccounts

    private val _iAccount = MutableLiveData<Response<BankAccount>>()
    val iAccount : LiveData<Response<BankAccount>>
        get() =  _iAccount


    fun getAccountByAccountNumber(accno:String) = viewModelScope.launch {
        _gAccount.postValue(accountRepo.getAcountByAccountNumber(accno))
    }

    fun getAllAccounts() = viewModelScope.launch {
        _gAllAccounts.postValue(accountRepo.getAllAccount())
    }
    fun updateAccount(account: BankAccount)=viewModelScope.launch {
        _iAccount.postValue(accountRepo.updateAccount(account))
    }
}