package com.kserno.bp.model

import com.kserno.bp.db.entity.NotificationSettingsEntity

/**
 *  Created by filipsollar on 2019-04-24
 */
data class NotificationSettingsModel(
        var enabled: Boolean,
        var apps: String
) {
    fun transformEntity(entity: NotificationSettingsEntity): NotificationSettingsEntity {
        entity.enabled = enabled
        entity.apps = apps

        return entity
    }
}