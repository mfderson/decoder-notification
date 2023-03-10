package com.ead.notification.services

import com.ead.notification.models.NotificationModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface NotificationService {

    fun save(notificationModel: NotificationModel): NotificationModel
    fun findAllNotificationsByUser(userId: UUID, pageable: Pageable): Page<NotificationModel>
    fun findByIdAndUserId(id: UUID, userId: UUID): NotificationModel?
}