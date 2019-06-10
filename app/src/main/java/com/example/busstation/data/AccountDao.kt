package com.example.busstation.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAccount(account:BankAccount)

     @Delete
     fun deleteAccount(account: BankAccount)

    @Query("SELECT * FROM bank_account_table")
    fun getAllAccount():LiveData<List<BankAccount>>



}