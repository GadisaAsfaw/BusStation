package com.example.busstation.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TransportInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInfo(trasportInfo:TransportInfo)

    @Update
    fun updateInfo(trasportInfo: TransportInfo)

    @Delete
    fun deleteInfo(trasportInfo: TransportInfo)

    @Query("SELECT * FROM basic_transport_info")
    fun getAllInfo():LiveData<List<TransportInfo>>
}
