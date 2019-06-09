package com.example.busstation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "driver_table")
data class Driver(
    @ColumnInfo(name = "user_name") val userName:String,
    @ColumnInfo(name = "password") val password:String,
    @PrimaryKey @ColumnInfo(name = "id_no") val idNo:String,

    @ColumnInfo(name = "licenceNo") val licenceNo:String,
    @ColumnInfo(name = "car_vin") val carVin:String,
    @ColumnInfo(name = "car_side_no") val carSideNo:Int,
    @ColumnInfo(name = "seat_no") val seatNo:Int,
    @ColumnInfo(name = "acc_no") val accNo:String //foreign
)