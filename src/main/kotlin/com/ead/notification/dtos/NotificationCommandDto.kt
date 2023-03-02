package com.ead.notification.dtos

import com.ead.notification.models.NotificationModel
import java.util.UUID

data class NotificationCommandDto(
    val title: String = "",
    val message: String = "",
    val userId: UUID = UUID.randomUUID()
)

fun NotificationCommandDto.toNotificationModel() = NotificationModel(
    userId = userId,
    title = title,
    message = message
)