package com.kserno.bp.model

import com.kserno.bp.db.entity.MessageSettingsEntity

/**
 *  Created by filipsollar on 2019-04-24
 */
data class MessageSettingsModel(
        var enabled: Boolean,
        var readText: String,
        var readUnknownNumbers: Boolean
) {
    fun transformEntity(entity: MessageSettingsEntity): MessageSettingsEntity {
        entity.enabled = enabled
        entity.readText = readText
        entity.readUnknownNumbers = readUnknownNumbers

        return entity
    }
}