package com.ead.notification.services.impl

import com.ead.notification.enums.NotificationStatus
import com.ead.notification.models.NotificationModel
import com.ead.notification.repositories.NotificationRepository
import com.ead.notification.services.NotificationService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class NotificationServiceImpl(
    val notificationRepository: NotificationRepository
): NotificationService {
    override fun save(notificationModel: NotificationModel) =
        notificationRepository.save(notificationModel)

    override fun findAllNotificationsByUser(userId: UUID, pageable: Pageable) =
        notificationRepository.findAllByUserIdAndStatus(userId, NotificationStatus.CREATED, pageable)

    override fun findByIdAndUserId(id: UUID, userId: UUID) =
        notificationRepository.findByIdAndUserId(id, userId)

}