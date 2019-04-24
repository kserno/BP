package com.kserno.bp.model

import com.kserno.bp.db.entity.GlobalSettingsEntity

/**
 *  Created by filipsollar on 2019-04-24
 */
data class GlobalSettingsModel(
        var enabled: Boolean
) {
    fun transformEntity(globalSettingsEntity: GlobalSettingsEntity): GlobalSettingsEntity {
        globalSettingsEntity.enabled = enabled

        return globalSettingsEntity
    }
}