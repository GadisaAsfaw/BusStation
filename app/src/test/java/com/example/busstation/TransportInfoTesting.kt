package com.example.busstation

import androidx.test.InstrumentationRegistry
import com.example.busstation.data.MYDatabase
import com.example.busstation.data.TransportInfo
import com.example.busstation.data.User
import org.junit.Assert
import org.junit.Test

class TransportInfoTesting {


    val appContext = InstrumentationRegistry.getTargetContext()

    @Test
    fun deleteInfo() {
        val info = TransportInfo("addis ababa","shashemene","3/10/2012","11:00pm","ATR/0799/09")
        MYDatabase.getDatabase(appContext).transportInfoDao().insertInfo(info)
        var infoDb = MYDatabase.getDatabase(appContext).transportInfoDao().getAllInfo()
        MYDatabase.getDatabase(appContext).transportInfoDao().deleteInfo(info)
        infoDb = MYDatabase.getDatabase(appContext).transportInfoDao().getAllInfo()
        Assert.assertNull(infoDb)
    }

    @Test
    fun updateInfo() {
        val info = TransportInfo("addis ababa","shashemene","3/10/2012","11:00pm","ATR/0799/09")
        val infoDb = MYDatabase.getDatabase(appContext).transportInfoDao().getInfo()

        MYDatabase.getDatabase(appContext).transportInfoDao().updateInfo(info)

        Assert.assertEquals(infoDb?.startPos, info.startPos)
        Assert.assertEquals(infoDb?.destinationPos, info.destinationPos)
        Assert.assertEquals(infoDb?.transportDate, info.transportDate)
        Assert.assertEquals(infoDb?.transportTime, info.transportTime)
        Assert.assertEquals(infoDb?.driverIdNo, info.driverIdNo)

    }

    @Test
    fun insertInfo() {
        val info = TransportInfo("addis ababa","shashemene","3/10/2012","11:00pm","ATR/0799/09")
        val infoDb = MYDatabase.getDatabase(appContext).transportInfoDao().getInfo()



        MYDatabase.getDatabase(appContext).transportInfoDao().insertInfo(info)

        Assert.assertEquals(infoDb?.startPos, info.startPos)
        Assert.assertEquals(infoDb?.destinationPos, info.destinationPos)
        Assert.assertEquals(infoDb?.transportDate, info.transportDate)
        Assert.assertEquals(infoDb?.transportTime, info.transportTime)
        Assert.assertEquals(infoDb?.driverIdNo, info.driverIdNo)

    }
}