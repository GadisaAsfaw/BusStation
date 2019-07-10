package com.example.busstation

import androidx.test.InstrumentationRegistry
import com.example.busstation.data.BankAccount
import com.example.busstation.data.MYDatabase
import com.example.busstation.data.User
import org.junit.Assert
import org.junit.Test

class BankAccountTesting {

    val appContext = InstrumentationRegistry.getTargetContext()

    @Test
    fun deleteBankAcc() {
        val bank = BankAccount("cbe50","ibrahim", 5000.7F)
        MYDatabase.getDatabase(appContext).accountDao().insertAccount(bank)
        var bankDb = MYDatabase.getDatabase(appContext).accountDao().getAccount()
        MYDatabase.getDatabase(appContext).accountDao().deleteAccount(bankDb)
        bankDb = MYDatabase.getDatabase(appContext).accountDao().getAccount()
        Assert.assertNull(bankDb)
    }
    @Test
    fun insertBankAcc() {
        val bank = BankAccount("cbe50","ibrahim", 5000.7F)
        val bankDb = MYDatabase.getDatabase(appContext).accountDao().getAccount()



        MYDatabase.getDatabase(appContext).accountDao().insertAccount(bank)

        Assert.assertEquals(bankDb?.acc_number, bank.acc_number)
        Assert.assertEquals(bankDb?.password, bank.password)
        Assert.assertEquals(bankDb?.balance, bank.balance)



    }
}