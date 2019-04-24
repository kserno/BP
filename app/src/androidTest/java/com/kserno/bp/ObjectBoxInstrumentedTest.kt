package com.kserno.bp

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
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
import java.io.File

/**
 *  Created by filipsollar on 2019-04-25
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ObjectBoxInstrumentedTest {

    companion object {
        const val TEST_DB_NAME = "TEST_DB"
    }

    private var boxStore: BoxStore? = null
    private lateinit var database: ObjectBoxDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        BoxStore.deleteAllFiles(context, TEST_DB_NAME)
        boxStore = MyObjectBox.builder()
                .name(TEST_DB_NAME)
                .androidContext(context)
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
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        BoxStore.deleteAllFiles(context, TEST_DB_NAME)
    }

}