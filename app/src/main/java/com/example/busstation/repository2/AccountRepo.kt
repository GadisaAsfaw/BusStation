package com.example.busstation.repository2

import com.example.busstation.data2.BankAccount
import com.example.busstation.network.UserAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class AccountRepo(private val userAPIService: UserAPIService) {
    suspend fun getAcountByAccountNumber(accno:String): Response<BankAccount> =
        withContext(Dispatchers.IO){
            userAPIService.getAccountByAccountNumber(accno).await()
        }
    suspend  fun getAllAccount(): Response<List<BankAccount>> =
        withContext(Dispatchers.IO){
            userAPIService.getAllAccounts().await()
        }
    suspend  fun updateAccount(account:BankAccount): Response<BankAccount> =
        withContext(Dispatchers.IO){
            userAPIService.updateAccount(account).await()
        }
}