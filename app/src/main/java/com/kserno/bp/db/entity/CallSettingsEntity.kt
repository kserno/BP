package com.kserno.bp.db.entity

import com.kserno.bp.model.CallSettingsModel
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 *  Created by filipsollar on 2019-04-24
 */
@Entity
data class CallSettingsEntity(
        @Id var id: Long,
        var enabled: Boolean,
        var readText: String,
        var readUnknownNumbers: Boolean
) {
    fun toModel(): CallSettingsModel {
        return CallSettingsModel(
                enabled,
                readText,
                readUnknownNumbers
        )
    }
}