package com.kserno.bp.db

import android.content.Context
import com.kserno.bp.db.entity.CallSettingsEntity
import com.kserno.bp.db.entity.GlobalSettingsEntity
import com.kserno.bp.db.entity.MessageSettingsEntity
import com.kserno.bp.db.entity.MyObjectBox
import com.kserno.bp.db.entity.NotificationSettingsEntity
import com.kserno.bp.model.CallSettingsModel
import com.kserno.bp.model.GlobalSettingsModel
import com.kserno.bp.model.MessageSettingsModel
import com.kserno.bp.model.NotificationSettingsModel
import io.objectbox.BoxStore
import io.objectbox.BoxStoreBuilder
import io.objectbox.kotlin.boxFor

/**
 *  Created by filipsollar on 2019-04-24
 */
class ObjectBoxDatabase(
        private val boxStore: BoxStore
): Database {

    override fun getGlobalSettingsModel(): GlobalSettingsModel {
        return getSingleObject(defaultGlobal).toModel()
    }

    override fun getCallSettingsModel(): CallSettingsModel {
        return getSingleObject(defaultCall).toModel()
    }

    override fun getMessageSettingsModel(): MessageSettingsModel {
        return getSingleObject(defaultMessage).toModel()
    }

    override fun getNotificationSettingsModel(): NotificationSettingsModel {
        return getSingleObject(defaultNotifications).toModel()
    }

    override fun updateGlobalSettingsModel(model: GlobalSettingsModel) {
        val box = boxStore.boxFor(GlobalSettingsEntity::class)
        box.put(model.transformEntity(box.all.first()))
    }

    override fun updateCallSettingsModel(model: CallSettingsModel) {
        val box = boxStore.boxFor(CallSettingsEntity::class)
        box.put(model.transformEntity(box.all.first()))
    }

    override fun updateMessageSettingsModel(model: MessageSettingsModel) {
        val box = boxStore.boxFor(MessageSettingsEntity::class)
        box.put(model.transformEntity(box.all.first()))
    }

    override fun updateNotificationsSettingsModel(model: NotificationSettingsModel) {
        val box = boxStore.boxFor(NotificationSettingsEntity::class)
        box.put(model.transformEntity(box.all.first()))
    }

    private inline fun <reified T> getSingleObject(defaultValue: T): T {
        val globalBox = boxStore.boxFor(T::class.java)
        if (globalBox.isEmpty) {
            globalBox.put(
                    defaultValue
            )
        }
        return globalBox.all.first()
    }


}