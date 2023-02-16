package com.ead.notification.services

import com.ead.notification.models.NotificationModel

interface NotificationService {

    fun save(notificationModel: NotificationModel): NotificationModel
}