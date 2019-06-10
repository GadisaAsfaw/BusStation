package com.example.busstation.repository

import androidx.lifecycle.LiveData
import com.example.busstation.data.AccountDao
import com.example.busstation.data.BankAccount


class AccountRepo(private val accountDao: AccountDao) {

    fun insertAccount(account:BankAccount){
        accountDao.insertAccount(account)
    }
    fun deletAccount(account: BankAccount){
        accountDao.deleteAccount(account)
    }
    fun getAllAccount():LiveData<List<BankAccount>> = accountDao.getAllAccount()
}