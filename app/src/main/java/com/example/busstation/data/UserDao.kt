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

    //@Query("SELECT * FROM traveller_table where user_name =:name")
    //fun getUser(name:String):MutableLiveData<User>

    @Query("SELECT * FROM traveller_table")
    fun getAllUser():LiveData<List<User>>

}