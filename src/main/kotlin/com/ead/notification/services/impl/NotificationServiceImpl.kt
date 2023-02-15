package com.ead.notification.services.impl

import com.ead.notification.repositories.NotificationRepository
import com.ead.notification.services.NotificationService
import org.springframework.stereotype.Service

@Service
class NotificationServiceImpl(
    val notificationRepository: NotificationRepository
): NotificationService {
}