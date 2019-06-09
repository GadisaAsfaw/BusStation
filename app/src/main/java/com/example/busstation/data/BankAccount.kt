package com.example.busstation.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank_account_table")
data class BankAccount(
    @PrimaryKey @ColumnInfo(name = "acc_no") val acc_number:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "balance") val balance:Float

)