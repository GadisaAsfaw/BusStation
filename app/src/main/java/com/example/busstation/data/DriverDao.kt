
package com.example.busstation.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface DriverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDriver(driver:Driver)
    @Update
    fun updateDriver(driver: Driver)

    @Delete
    fun deleteDriver(driver: Driver)
   // @Query("SELECT * FROM driver_table where user_name =:name")
   // fun getDriver(name:String):MutableLiveData<Driver>

    @Query("SELECT * FROM driver_table")
    fun getAllDriver():LiveData<List<Driver>>

}