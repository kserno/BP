package com.kserno.bp.model

import com.kserno.bp.db.entity.CallSettingsEntity

/**
 *  Created by filipsollar on 2019-04-24
 */
data class CallSettingsModel(
        var enabled: Boolean,
        var readText: String,
        var readUnknownNumbers: Boolean
) {
    fun transformEntity(entity: CallSettingsEntity): CallSettingsEntity {
        entity.enabled = enabled
        entity.readText = readText
        entity.readUnknownNumbers = readUnknownNumbers

        return entity
    }
}