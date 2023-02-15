package com.ead.notification.repositories

import com.ead.notification.models.NotificationModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface NotificationRepository: JpaRepository<NotificationModel, UUID> {
}