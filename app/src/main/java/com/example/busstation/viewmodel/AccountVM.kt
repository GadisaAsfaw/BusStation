package com.example.busstation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.busstation.data.BankAccount
import com.example.busstation.data.MYDatabase
import com.example.busstation.repository.AccountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountVM(application: Application):AndroidViewModel(application) {
    private  val accountRepo: AccountRepo

    init {
        val accountDao = MYDatabase.getDatabase(application).accountDao()
          accountRepo = AccountRepo(accountDao)
    }
    fun insertAccount(account:BankAccount) = viewModelScope.launch(Dispatchers.IO){
        accountRepo.insertAccount(account)
    }
    fun deleteAccount(account: BankAccount) = viewModelScope.launch(Dispatchers.IO){
        accountRepo.deletAccount(account)
    }
}