package com.example.busstation.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM traveller_table where user_name =:name and password=:pw")
    fun getUser(name:String,pw:String):LiveData<User>

    @Query("SELECT * FROM traveller_table")
    fun getAllUser():LiveData<List<User>>

    @Query("SELECT * FROM traveller_table")
    fun getUser():User


}