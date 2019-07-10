package com.example.busstation.data2

data class Driver(
     val userName:String,
     val password:String,
     val idNo:String,

     val licenceNo:String,
     val carVin:String,
     val carSideNo:Int,
     val seatNo:Int,
     val accNo:String //foreign
)