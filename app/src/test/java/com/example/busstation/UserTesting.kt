package com.example.busstation

import androidx.lifecycle.LiveData
import com.example.busstation.data.MYDatabase
import com.example.busstation.data.User
import org.junit.Assert.*
import androidx.test.InstrumentationRegistry
import org.junit.Test


class UserTesting {

    val appContext = InstrumentationRegistry.getTargetContext()

    @Test
    fun deleteUser() {
        val user = User("ibrahim","abas","atr/0799/09","driver")
        MYDatabase.getDatabase(appContext).userDao().insertUser(user)
        var userFromDb = MYDatabase.getDatabase(appContext).userDao().getUser()
        MYDatabase.getDatabase(appContext).userDao().deleteUser(userFromDb)
        userFromDb = MYDatabase.getDatabase(appContext).userDao().getUser()
        assertNull(userFromDb)
    }

    @Test
    fun updateUser() {
        val user = User("ibrahim","abas","atr/0799/09","driver")
        val userFromDb = MYDatabase.getDatabase(appContext).userDao().getUser()

        MYDatabase.getDatabase(appContext).userDao().updateUser(user)

        assertEquals(userFromDb?.userName, user.userName)
        assertEquals(userFromDb?.password,user.password)
        assertEquals(userFromDb?.idNo,user.idNo)
        assertEquals(userFromDb?.userType,user.userType)

    }

    @Test
    fun insertUser() {
        val user = User("ibrahim","abas","atr/0799/09","driver")
        val userFromDb = MYDatabase.getDatabase(appContext).userDao().getUser()



        MYDatabase.getDatabase(appContext).userDao().insertUser(user)

        assertEquals(userFromDb?.userName, user.userName )
        assertEquals(userFromDb?.password ,user.password)
        assertEquals(userFromDb?.idNo ,user.idNo)
        assertEquals(userFromDb?.userType,user.userType)


    }


}