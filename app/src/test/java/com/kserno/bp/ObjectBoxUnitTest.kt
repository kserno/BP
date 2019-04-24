package com.kserno.bp

import com.kserno.bp.db.ObjectBoxDatabase
import com.kserno.bp.db.defaultCall
import com.kserno.bp.db.defaultGlobal
import com.kserno.bp.db.defaultMessage
import com.kserno.bp.db.defaultNotifications
import com.kserno.bp.db.entity.MyObjectBox
import io.objectbox.BoxStore
import io.objectbox.DebugFlags
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.File

/**
 *  Created by filipsollar on 2019-04-24
 */
@RunWith(JUnit4::class)
class ObjectBoxUnitTest {

    private val TEST_DIRECTORY = File("objectbox/test-db")
    private var boxStore: BoxStore? = null
    private lateinit var database: ObjectBoxDatabase

    @Before
    fun setUp() {
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
        boxStore = MyObjectBox.builder()
                .directory(TEST_DIRECTORY)
                .debugFlags(DebugFlags.LOG_QUERIES)
                .build()

        database = ObjectBoxDatabase(boxStore!!)
    }

    
    @Test
    fun getDefaultGlobalModel() {
        Assert.assertEquals(database.getGlobalSettingsModel(), defaultGlobal.toModel())
    }

    @Test
    fun getDefaultMessageModel() {
        Assert.assertEquals(database.getMessageSettingsModel(), defaultMessage.toModel())
    }

    @Test
    fun getDefaultCallModel() {
        Assert.assertEquals(database.getCallSettingsModel(), defaultCall.toModel())
    }

    @Test
    fun getDefaultNotificationsModel() {
        Assert.assertEquals(database.getNotificationSettingsModel(), defaultNotifications.toModel())
    }

    @After
    fun tearDown() {
        boxStore?.close()
        BoxStore.deleteAllFiles(TEST_DIRECTORY)
    }

}