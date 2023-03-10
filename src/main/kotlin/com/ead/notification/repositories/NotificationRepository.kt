package com.ead.notification.repositories

import com.ead.notification.enums.NotificationStatus
import com.ead.notification.models.NotificationModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NotificationRepository: JpaRepository<NotificationModel, UUID> {

    fun findAllByUserIdAndStatus(
        userId: UUID,
        status: NotificationStatus,
        pageable: Pageable
    ): Page<NotificationModel>

    fun findByIdAndUserId(id: UUID, userId: UUID): NotificationModel?
}