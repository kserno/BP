package com.kserno.bp.db

import com.kserno.bp.model.CallSettingsModel
import com.kserno.bp.model.GlobalSettingsModel
import com.kserno.bp.model.MessageSettingsModel
import com.kserno.bp.model.NotificationSettingsModel

/**
 *  Created by filipsollar on 2019-04-24
 */
interface Database {

    fun getGlobalSettingsModel(): GlobalSettingsModel
    fun getCallSettingsModel(): CallSettingsModel
    fun getMessageSettingsModel(): MessageSettingsModel
    fun getNotificationSettingsModel(): NotificationSettingsModel

    fun updateGlobalSettingsModel(model: GlobalSettingsModel)
    fun updateCallSettingsModel(model: CallSettingsModel)
    fun updateMessageSettingsModel(model: MessageSettingsModel)
    fun updateNotificationsSettingsModel(model: NotificationSettingsModel)

}