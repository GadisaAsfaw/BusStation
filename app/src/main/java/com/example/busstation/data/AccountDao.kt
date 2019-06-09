package com.example.busstation.data

import androidx.room.*

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAccount(account:BankAccount)

     @Delete
     fun deleteAccount(account: BankAccount)



}