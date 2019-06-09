package com.example.busstation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "traveller_table")
data class User(
    @ColumnInfo(name = "user_name") val userName:String,
    @ColumnInfo(name = "password") val password:String,
    @PrimaryKey @ColumnInfo(name = "id_no") val idNo:String,
    @ColumnInfo(name = "user_type") val userType:String
    )
