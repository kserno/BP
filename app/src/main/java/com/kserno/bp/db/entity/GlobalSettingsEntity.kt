package com.kserno.bp.db.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 *  Created by filipsollar on 2019-04-24
 */
@Entity
data class GlobalSettingsEntity(
        @Id var id: Int,
        var enabled: Boolean
) {
}