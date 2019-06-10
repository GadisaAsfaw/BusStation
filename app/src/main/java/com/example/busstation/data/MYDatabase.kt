package com.example.busstation.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class,Driver::class,BankAccount::class,TransportInfo::class),version = 1)
abstract  class MYDatabase:RoomDatabase() {
    abstract  fun userDao():UserDao
    abstract  fun driverDao():DriverDao
    abstract  fun accountDao():AccountDao
    abstract  fun transportInfoDao():TransportInfoDao


    companion object {

        @Volatile
        private var INSTANCE: MYDatabase? = null

        fun getDatabase(context: Context): MYDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MYDatabase::class.java, "my_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}