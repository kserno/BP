package com.kserno.bp.db.entity

import com.kserno.bp.model.NotificationSettingsModel
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 *  Created by filipsollar on 2019-04-24
 */
@Entity
data class NotificationSettingsEntity(
        @Id var id: Long,
        var enabled: Boolean,
        var apps: String
) {
    fun toModel(): NotificationSettingsModel {
        return NotificationSettingsModel(
                enabled,
                apps
        )
    }
}