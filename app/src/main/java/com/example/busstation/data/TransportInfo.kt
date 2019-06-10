package com.example.busstation.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basic_transport_info")
data class TransportInfo(

    @ColumnInfo(name = "start_pos")  val startPos:String,
    @ColumnInfo(name = "dest_pos") val destinationPos:String,
    @ColumnInfo(name = "transport_date")val transportDate:String,
    @ColumnInfo(name="transport_time") val transportTime:String,
  @PrimaryKey  @ColumnInfo(name = "driver_id")val driverIdNo:String //foreign key and primary key


                         )
//val carSeatNo:Int,
//  val carSideNo:Int

