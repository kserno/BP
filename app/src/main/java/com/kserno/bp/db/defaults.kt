package com.kserno.bp.db

import com.kserno.bp.db.entity.CallSettingsEntity
import com.kserno.bp.db.entity.GlobalSettingsEntity
import com.kserno.bp.db.entity.MessageSettingsEntity
import com.kserno.bp.db.entity.NotificationSettingsEntity

/**
 *  Created by filipsollar on 2019-04-24
 */

val defaultGlobal = GlobalSettingsEntity(0L, false)
val defaultMessage = MessageSettingsEntity(0L, false, "", false)
val defaultCall = CallSettingsEntity(0L, false, "", false)
val defaultNotifications = NotificationSettingsEntity(0L, false, "")
